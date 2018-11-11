package shareparking

import grails.test.hibernate.HibernateSpec
import grails.testing.gorm.DomainUnitTest
import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification


class ParkingSpaceOwnerSpec extends HibernateSpec { //implements DomainUnitTest<ParkingSpaceOwner> {

    def setup() {
    }

    def cleanup() {
    }

    void "test valid data"() {
        when: 'A valid parkingSpace owner record is created'
        ParkingSpaceOwner parkingSpaceOwner = new ParkingSpaceOwner(id: '', userId: '1')
        parkingSpaceOwner.save()

        then: 'There are no errors and the data are saved'
        ParkingSpaceOwner.count() == 1
    }

    void "create a parking space owner and add two parking spaces belonging to this owner"() {
        when: 'A valid parkingSpace owner record is created'
        ParkingSpaceOwner parkingSpaceOwner = new ParkingSpaceOwner(id: '', userId: '1')
                .addToParkingspaces(new ParkingSpace(id: '', parkingSpaceOwnerId: '1', latitude: 1.123456, longitude: 1.123456, rating: 0))
                .addToParkingspaces(new ParkingSpace(id: '', parkingSpaceOwnerId: '1', latitude: 1.123456, longitude: 1.123456, rating: 0))
                .save()

        then: 'There are no errors and there is one parking space owner and one parking space'
        ParkingSpaceOwner.count() == 1
        ParkingSpace.count() == 2
    }

    void "delete a parking space owner cascaded"() {
        given:
        ParkingSpaceOwner.count() == 0
        ParkingSpace.count() == 0

        when: 'A valid parkingSpace owner and two associated parking spaces are created'
        ParkingSpaceOwner parkingSpaceOwner = new ParkingSpaceOwner(id: '', userId: '1')
                .addToParkingspaces(new ParkingSpace(id: '', parkingSpaceOwnerId: '1', latitude: 1.123456, longitude: 1.123456, rating: 0))
                .addToParkingspaces(new ParkingSpace(id: '', parkingSpaceOwnerId: '1', latitude: 1.123456, longitude: 1.123456, rating: 0))
                .save()

        then: 'There are no errors and there is one parking space owner and one parking space'
        ParkingSpaceOwner.count() == 1
        ParkingSpace.count() == 2


        when: 'Owner is deleted'
        parkingSpaceOwner.delete(flush: true)

        then: 'The parking spaces are also deleted'
        ParkingSpaceOwner.count() == 0
        ParkingSpace.count() == 0
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
