package shareparking

import grails.rest.RestfulController
import groovy.transform.CompileStatic

@CompileStatic
class UserProfileController extends RestfulController{
    static responseFormats = ['json', 'xml']

    UserProfileController() {
        super(UserProfile)
    }

    def search(String q, Integer max ) {
        if (q) {
            def query = UserProfile.where {
                firstName ==~ "%${q}%"
            }
            respond query.list(max: Math.min( max ?: 10, 100))
        }
        else {
            respond([])
        }
    }

}
