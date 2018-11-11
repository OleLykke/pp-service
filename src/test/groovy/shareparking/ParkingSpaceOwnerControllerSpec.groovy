package shareparking

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class ParkingSpaceOwnerControllerSpec extends Specification implements ControllerUnitTest<ParkingSpaceOwnerController>, DataTest {

    def setup() {
    }

    def cleanup() {
    }

    Class<?>[] getDomainClassesToMock(){
        return [ParkingSpaceOwner] as Class[]
    }

    void "test it is possible to add a parking space to an existing owner"() {
        given:
        ParkingSpaceOwner parkingSpaceOwner = new ParkingSpaceOwner(id: '', userId: '1')
        parkingSpaceOwner.save()

        when: 'A parking space is added to the owner'
        controller.addParkingSpace(parkingSpaceOwner, new ParkingSpace(id: '', parkingSpaceOwnerId: '1', latitude: 1.123456, longitude: 1.123456, rating: 0))

        then: 'Then the should be one parking space associated to the owner'
        controller.getParkingSpaces(parkingSpaceOwner).size() == 1
    }

    void "test 2 it is possible to add a parking space to an existing owner"() {
        given:
        ParkingSpaceOwner parkingSpaceOwner = new ParkingSpaceOwner(id: '', userId: '1')
        parkingSpaceOwner.save()

        when: 'A parking space is added to the owner'
        controller.addParkingSpace(parkingSpaceOwner.getId(), 1.123456, 1.123456,0)

        then: 'Then the should be one parking space associated to the owner'
        controller.getParkingSpaces(parkingSpaceOwner).size() == 1
    }

}
