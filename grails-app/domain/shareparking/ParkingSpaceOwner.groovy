package shareparking

class ParkingSpaceOwner {

    Integer id
    Integer user_id

    static constraints = {
        id nullable: true
        user_id nullable: false
    }
}
