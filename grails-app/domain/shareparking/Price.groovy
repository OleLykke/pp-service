package shareparking

class Price {

    Integer id
    Integer user_id
    Double price
    String unit
    String currency

    static constraints = {
        id nullable:true
        user_id nullable:false
        price range: 0.00..9999.99
        unit blank:false
        currency blank:false
    }
}
