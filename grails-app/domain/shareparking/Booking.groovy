package shareparking

class Booking {

    //static belongsTo = [parkingspace: ParkingSpace, driver: Driver]

    Integer id
    Integer parkingSpaceId
    Integer driverId
    Date arrive
    Date leave
    Double amount
    String currency

    static mapping = {
        table 'booking'
        id generator: 'identity'
        version false
        parkingSpaceId column:'parking_space_id'
        driverId column:'driver_id'
    }

    static constraints = {
        id nullable:true
        parkingSpaceId nullable:false
        driverId nullable:false
        arrive nullable:true
        leave nullable:true
        amount nullable:true
        currency blank:false
    }
}
