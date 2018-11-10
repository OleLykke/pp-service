package shareparking

class Booking {

    Integer id
    Integer parkingSpaceId
    Integer driverId
    Date arrive
    Date leave
    Double amount
    String currency

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
