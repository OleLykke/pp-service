package shareparking

import grails.gorm.services.Service

@Service(ParkingSpaceOwner)
interface ParkingSpaceOwnerService {

    ParkingSpaceOwner get(Serializable id)

    List<ParkingSpaceOwner> list(Map args)

    Long count()

    void delete(Serializable id)

    ParkingSpaceOwner save(ParkingSpaceOwner parkingSpaceOwner)

}