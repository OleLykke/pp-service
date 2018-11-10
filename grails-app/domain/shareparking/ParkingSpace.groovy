package shareparking

class ParkingSpace {

    Integer id
    Integer parking_space_owner_id
    Double latitude
    Double longitude
    Integer rating

    static constraints = {
        id nullable: true
        parking_space_owner_id nullable: false
        latitude range: -90.000000..90.000000
        longitude range: -180.000000..180.000000
        rating nullable: true
    }
}
