package shareparking

import grails.plugin.json.view.mvc.JsonViewResolver
import grails.test.hibernate.HibernateSpec
import grails.testing.web.controllers.ControllerUnitTest

@SuppressWarnings('MethodName')
class UserProfileControllerSpec extends HibernateSpec implements ControllerUnitTest<UserProfileController> {

    static doWithSpring = {
        jsonSmartViewResolver(JsonViewResolver)
    }

    void setup() {
        UserProfile.saveAll(
                new UserProfile(firstName: 'Ole Lykke', lastName: 'Jacobsen', mobile: '+45 31 37 06 65', email: 'olj@nine.dk', userName: 'ole', password: 'ole'),
                new UserProfile(firstName: 'Magnus Lykke', lastName: 'Jacobsen', mobile: 'n/a', email: 'n/a', userName: 'magnus', password: 'magnus')
        )
    }

    void 'test the search action finds results'() {
        when: 'A query is executed that finds one result'
        controller.search('nu', 10)

        then: 'The response is correct'
        response.json.size() == 1
        response.json[0].firstName == 'Magnus Lykke'
    }
}
