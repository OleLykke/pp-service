package shareparking

import grails.testing.gorm.DomainUnitTest
import grails.test.hibernate.HibernateSpec



class UserProfileSpec extends HibernateSpec { //implements DomainUnitTest<UserProfile> {

    void "test valid data"() {
        when: 'A userProfile with valid data is created'
        UserProfile userProfile = new UserProfile(id: '', firstName: 'Ole Lykke', lastName: 'Jacobsen', mobile: '31 37 06 65', email: 'olj@nine.dk', userName: 'ole', password: 'ole')
        userProfile.save()

        then: 'There are no errors and the data are saved'
        UserProfile.count() == 1
        UserProfile.first().id == 1
    }

    void "test constaints violations"() {
        when: 'Ateempt to create a userProfile with invalid data'
        UserProfile userProfile = new UserProfile(id: '', firstName: '', lastName: '', mobile: '', email: '', userName: '', password: '')
        userProfile.save()

        then: 'There are no errors and the data are saved'
        userProfile.hasErrors()
        userProfile.errors.getFieldError('firstName')
        userProfile.errors.getFieldError('lastName')
        userProfile.errors.getFieldError('mobile')
        userProfile.errors.getFieldError('email')
        userProfile.errors.getFieldError('userName')
        userProfile.errors.getFieldError('password')
        UserProfile.count() == 0
    }

    void "test create two user profiles"() {
        when: 'Two userProfiles are created'
        UserProfile ole = new UserProfile(id: '', firstName: 'Ole Lykke', lastName: 'Jacobsen', mobile: '31 37 06 65', email: 'olj@nine.dk', userName: 'ole', password: 'ole')
        ole.save()

        UserProfile magnus = new UserProfile(id: '', firstName: 'Magnus Lykke', lastName: 'Jacobsen', mobile: 'n/a', email: 'n/a', userName: 'magnus', password: 'magnus')
        magnus.save()

        then: 'There are no errors and the data are saved'
        UserProfile.count() == 2
        UserProfile.first().firstName == 'Ole Lykke'
        UserProfile.last().firstName == 'Magnus Lykke'
    }
}
