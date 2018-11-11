package shareparking

import grails.rest.RestfulController

class ParkingSpaceOwnerController extends RestfulController {
    static responseFormats = ['json', 'xml']

    ParkingSpaceOwnerController() {
        super(ParkingSpaceOwner)
    }

    //def addParkingSpace(ParkingSpaceOwner parkingSpaceOwner, ParkingSpace parkingSpace) {
    //    parkingSpaceOwner.addToParkingspaces(parkingSpace)
    //}

    def addParkingSpace() {
        println ("params " + params)
        ParkingSpaceOwner parkingSpaceOwner = ParkingSpaceOwner.get(ownerId)

        parkingSpaceOwner.addToParkingspaces(new ParkingSpace(id: '', parkingSpaceOwnerId: ownerId, latitude: 1.123456, longitude: 1.123456, rating: 0))
    }

    def dummy() {
        println("dummy  dummy")
    }


    def Set<ParkingSpace> getParkingSpaces(ParkingSpaceOwner parkingSpaceOwner) {
        return parkingSpaceOwner.parkingspaces
    }
}
