package shareparking

class ParkingSpace {

    //static hasMany = [bookings: Booking]

    Integer id
    Integer parkingSpaceOwnerId
    Double latitude
    Double longitude
    Integer rating

    static mapping = {
        table 'parking_space'
        id generator: 'identity'
        version false
        parkingSpaceOwnerId column:'parking_space_owner_id'
    }

    static constraints = {
        id nullable: true
        parkingSpaceOwnerId nullable: false
        latitude range: -90.000000..90.000000
        longitude range: -180.000000..180.000000
        rating nullable: true
    }
}
