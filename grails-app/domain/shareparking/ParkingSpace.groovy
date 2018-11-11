package shareparking

class ParkingSpace {

    //static hasMany = [bookings: Booking]
    static belongsTo = [parkingspaceowner: ParkingSpaceOwner]

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
        latitude indexColumn: [name: 'the_latitude', type: Double]
        longitude indexColumn: [name: 'the_longitude', type: Double]
    }

    static constraints = {
        id nullable: true
        parkingSpaceOwnerId nullable: false
        latitude range: -90.000000..90.000000
        longitude range: -180.000000..180.000000
        rating nullable: true
    }
}
