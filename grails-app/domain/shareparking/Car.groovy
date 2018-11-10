package shareparking

class Car {

    Integer id
    Integer driverId
    String licensePlate

    static constraints = {
        id nullable:true
        driverId nullable:false
        licensePlate blank:false
    }
}
