package shareparking

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class UserProfile {
    //static belongsTo = [parkingspaceowner: ParkingSpaceOwner, driver: Driver]

    Integer id
    String firstName
    String lastName
    String mobile
    String email
    String userName
    String password

    static mapping = {
        table "user_profile"
        firstName indexColumn: [name: 'the_first_name', type: String]
        lastName indexColumn: [name: 'the_last_name', type: String]
    }

    static constraints = {
        id nullable:true
        firstName blank:false
        lastName blank:false
        mobile blank:false
        email blank:false
        userName blank:false
        password blank:false
    }
}
