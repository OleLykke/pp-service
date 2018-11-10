package shareparking

import grails.test.hibernate.HibernateSpec
import grails.testing.gorm.DomainUnitTest
import spock.lang.Ignore
import spock.lang.Specification


class ParkingSpaceSpec extends HibernateSpec { //implements DomainUnitTest<ParkingSpace> {

    def setup() {
    }

    def cleanup() {
    }

    void "test valid data"() {
        when: 'A valid parkingspace record is created'
        ParkingSpace parkingSpace = new ParkingSpace(id: '', parking_space_owner_id: '1', latitude: 1.123456, longitude: 1.123456, rating: 0)
        parkingSpace.save()

        then: 'There are no errors and the data are saved'
        ParkingSpace.count() == 1
        ParkingSpace.first().parking_space_owner_id == 1
    }

    void "test constraints violations"() {
        when: 'An invalid parkingSpace is attempted'
        ParkingSpace parkingSpace = new ParkingSpace(id: '', parking_space_owner_id: '', latitude: -91.000001, longitude: 181.000001, rating: 0)
        parkingSpace.save()

        then: 'There are no errors and the data are saved'
        parkingSpace.hasErrors()
        parkingSpace.errors.getFieldError('parking_space_owner_id')
        parkingSpace.errors.getFieldError('latitude')
        parkingSpace.errors.getFieldError('longitude')
        ParkingSpace.count() == 0
    }

}
