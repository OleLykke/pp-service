package shareparking

class Price {

    //static belongsTo = [parkingspace: ParkingSpace]

    Integer id
    Integer parkingSpaceId
    Double price
    String unit
    String currency

    static mapping = {
        table 'price'
        id generator: 'identity'
        version false
        parkingSpaceId column:'parking_space_id'
    }


    static constraints = {
        id nullable:true
        parkingSpaceId nullable:false
        price range: 0.00..9999.99
        unit blank:false
        currency blank:false
    }
}
