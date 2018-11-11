package shareparking

import grails.rest.RestfulController

class ParkingSpaceOwnerController extends RestfulController {
    static responseFormats = ['json', 'xml']

    ParkingSpaceOwnerController() {
        super(ParkingSpaceOwner)
    }

}
