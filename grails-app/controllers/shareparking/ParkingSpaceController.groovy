package shareparking

import grails.rest.RestfulController

class ParkingSpaceController extends RestfulController {
    static responseFormats = ['json', 'xml']

    ParkingSpaceController() {
        super(ParkingSpace)
    }


}
