package shareparking

import grails.rest.RestfulController

class ParkingSpaceOwnerController extends RestfulController {
    static responseFormats = ['json', 'xml']

    ParkingSpaceOwnerController() {
        super(ParkingSpaceOwner)
    }

    void addParkingSpace(ParkingSpaceOwner parkingSpaceOwner, ParkingSpace parkingSpace) {
        parkingSpaceOwner.addToParkingspaces(parkingSpace)
    }

    Set<ParkingSpace> getParkingSpaces(ParkingSpaceOwner parkingSpaceOwner) {
        return parkingSpaceOwner.parkingspaces
    }
}
