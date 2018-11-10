package shareparking

class Driver {

    Integer id
    Integer userId
    Date quarantine
    String rating

    static constraints = {
        id nullable:true
        userId nullable:false
        quarantine nullable:true
        rating blank:true
    }
}
