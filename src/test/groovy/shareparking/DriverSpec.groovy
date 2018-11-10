package shareparking

import grails.test.hibernate.HibernateSpec
import grails.testing.gorm.DomainUnitTest
import spock.lang.Ignore
import spock.lang.Specification


class DriverSpec extends HibernateSpec { //implements DomainUnitTest<Driver> {

    def setup() {
    }

    def cleanup() {
    }

    void "test valid data"() {
        when: 'A valid driver record is created'
        Driver driver = new Driver(id: '', userId: '1', quarantine: new Date(), rating: '2')
        driver.save()

        then: 'There are no errors and the data are saved'
        Driver.count() == 1
        Driver.first().userId == 1
    }

    void "test constraints violations"() {
        when: 'An invalid driver is attempted'
        Driver driver = new Driver(id: '', userId: '', quarantine: '', rating: '')
        driver.save()

        then: 'There are no errors and the data are saved'
        driver.hasErrors()
        driver.errors.getFieldError('userId')
        Driver.count() == 0
    }
}
