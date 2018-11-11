package shareparking

class Car {

    Integer id
    Integer driverId
    String licensePlate

    static mapping = {
        table 'car'
        id generator: 'identity'
        version false
        driverId column:'driver_id'
        licensePlate indexColumn: [name: 'the_license_plate', type: String]
    }


    static constraints = {
        id nullable:true
        driverId nullable:false
        licensePlate blank:false
    }
}
