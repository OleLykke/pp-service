package shareparking

import grails.test.hibernate.HibernateSpec
import grails.testing.gorm.DomainUnitTest
import spock.lang.Ignore
import spock.lang.Specification

class CarSpec extends HibernateSpec { //implements DomainUnitTest<Car> {

    def setup() {
    }

    def cleanup() {
    }

    void "test valid data"() {
        when: 'A valid car record is created'
        Car car = new Car(id: '', driverId: '1', licensePlate: 'BT 19 527')
        car.save()

        then: 'There are no errors and the data are saved'
        Car.count() == 1
        Car.first().licensePlate == 'BT 19 527'
    }

    void "test constraints violations"() {
        when: 'An invalid car is attempted'
        Car car = new Car(id: '', driverId: '', licensePlate: '')
        car.save()

        then: 'There are no errors and the data are saved'
        car.hasErrors()
        car.errors.getFieldError('driverId')
        car.errors.getFieldError('licensePlate')
        Car.count() == 0
    }
}
