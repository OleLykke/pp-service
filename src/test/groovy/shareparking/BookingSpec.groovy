package shareparking

import grails.test.hibernate.HibernateSpec
import grails.testing.gorm.DomainUnitTest
import spock.lang.Ignore
import spock.lang.Specification


class BookingSpec extends HibernateSpec { //implements DomainUnitTest<Booking> {

    def setup() {
    }

    def cleanup() {
    }

    void "test valid data"() {
        when: 'A valid booking record is created'
        Booking booking = new Booking(id: '', parkingSpaceId: '1', driverId: '1', arrive: new Date(), leave: new Date(), amount: 123.45, currency: 'DKK')
        booking.save()

        then: 'There are no errors and the data are saved'
        Booking.count() == 1
        Booking.first().parkingSpaceId == 1
    }

    void "test constraints violations"() {
        when: 'An invalid booking is attempted'
        Booking booking = new Booking(id: '', parkingSpaceId: '', driverId: '', arrive: '', leave: '', amount: '', currency: '')
        booking.save()

        then: 'There are errors and no data are saved'
        booking.hasErrors()
        booking.errors.getFieldError('parkingSpaceId')
        booking.errors.getFieldError('driverId')
        booking.errors.getFieldError('currency')

        Booking.count() == 0
    }
}
