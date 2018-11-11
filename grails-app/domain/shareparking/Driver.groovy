package shareparking

class Driver {

    static hasMany = [cars: Car, bookings: Booking]

    //static belongsTo = [userProfile: UserProfile]

    Integer id
    Integer userId
    Date quarantine
    String rating

    static mapping = {
        table 'driver'
        id generator: 'identity'
        version false
        userId column:'user_id'
        userId indexColumn: [name: 'the_driver', type: Integer]
    }


    static constraints = {
        id nullable:true
        userId nullable:false
        quarantine nullable:true
        rating blank:true
    }
}
