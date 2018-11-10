package shareparking

import grails.test.hibernate.HibernateSpec
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PriceSpec extends HibernateSpec { // implements DomainUnitTest<Price> {

    def setup() {
    }

    def cleanup() {
    }

    void "test valid data"() {
        when: 'A valid price record is created'
        Price price = new Price(id: '', user_id: '1', price: 12.34, unit: 'per hour', currency: 'DKK')
        price.save()

        then: 'There are no errors and the data are saved'
        Price.count() == 1
        Price.first().price == 12.34
    }

    void "test constraints violations"() {
        when: 'An invalid price is attempted'
        Price price = new Price(id: '', user_id: '1', price: 10000, unit: 'per hour', currency: 'DKK')
        price.save()

        then: 'There are no errors and the data are saved'
        price.hasErrors()
        price.errors.getFieldError('price')
        Price.count() == 0
    }
}
