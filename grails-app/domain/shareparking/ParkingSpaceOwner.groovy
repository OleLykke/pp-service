package shareparking

class ParkingSpaceOwner {

    static hasMany = [parkingspaces: ParkingSpace]

    Integer id
    Integer userId

    static mapping = {
        table 'parking_space_owner'
        parkingspaces cascade: 'all-delete-orphan'
        id generator: 'identity'
        version false
        userId column:'user_id'
    }


    static constraints = {
        id nullable: true
        userId nullable: false
    }
}
