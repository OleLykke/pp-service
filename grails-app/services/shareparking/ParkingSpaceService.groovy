package shareparking

import grails.gorm.services.Service

@Service(ParkingSpace)
interface ParkingSpaceService {

    ParkingSpace get(Serializable id)

    List<ParkingSpace> list(Map args)

    Long count()

    void delete(Serializable id)

    ParkingSpace save(ParkingSpace parkingSpace)

}