package shareparking

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class UserProfile {
    static mapping = {
        table "user_profile"
    }

    //static belongsTo = [parkingspaceowner: ParkingSpaceOwner, driver: Driver]

    Integer id
    String firstName
    String lastName
    String mobile
    String email
    String userName
    String password

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
