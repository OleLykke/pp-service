package shareparking

import grails.test.hibernate.HibernateSpec
import grails.testing.gorm.DomainUnitTest
import spock.lang.Ignore
import spock.lang.Specification


class ParkingSpaceOwnerSpec extends HibernateSpec { //implements DomainUnitTest<ParkingSpaceOwner> {

    def setup() {
    }

    def cleanup() {
    }

    void "test valid data"() {
        when: 'A valid parkingSpace record is created'
        ParkingSpaceOwner parkingSpaceOwner = new ParkingSpaceOwner(id: '', userId: '1')
        parkingSpaceOwner.save()

        then: 'There are no errors and the data are saved'
        ParkingSpaceOwner.count() == 1
    }

    void "test constraints violations"() {
        when: 'An invalid parkingSpace record is attempted'
        ParkingSpaceOwner parkingSpaceOwner = new ParkingSpaceOwner(id: '', userId: '')
        parkingSpaceOwner.save()

        then: 'There are no errors and the data are saved'
        parkingSpaceOwner.hasErrors()
        parkingSpaceOwner.errors.getFieldError('userId')
        ParkingSpaceOwner.count() == 0
    }
}
