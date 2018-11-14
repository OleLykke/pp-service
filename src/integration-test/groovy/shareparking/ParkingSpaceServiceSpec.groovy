package shareparking

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ParkingSpaceServiceSpec extends Specification {

    ParkingSpaceService parkingSpaceService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ParkingSpace(...).save(flush: true, failOnError: true)
        //new ParkingSpace(...).save(flush: true, failOnError: true)
        new ParkingSpace(id: '', parkingSpaceOwnerId: '1', latitude: 1.123456, longitude: 1.123456, rating: 0).save(flush: true, failOnError: true)
        new ParkingSpace(id: '', parkingSpaceOwnerId: '1', latitude: 2.123456, longitude: 2.123456, rating: 1).save(flush: true, failOnError: true)
        //ParkingSpace parkingSpace = new ParkingSpace(...).save(flush: true, failOnError: true)
        ParkingSpace parkingSpace = new ParkingSpace(id: '', parkingSpaceOwnerId: '1', latitude: 3.123456, longitude: 3.123456, rating: 2).save(flush: true, failOnError: true)
        //new ParkingSpace(...).save(flush: true, failOnError: true)
        //new ParkingSpace(...).save(flush: true, failOnError: true)
        new ParkingSpace(id: '', parkingSpaceOwnerId: '1', latitude: 4.123456, longitude: 4.123456, rating: 3).save(flush: true, failOnError: true)
        new ParkingSpace(id: '', parkingSpaceOwnerId: '1', latitude: 5.123456, longitude: 5.123456, rating: 4).save(flush: true, failOnError: true)
        //assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        parkingSpace.id
    }

    void "test get"() {
        setupData()

        expect:
        parkingSpaceService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ParkingSpace> parkingSpaceList = parkingSpaceService.list(max: 2, offset: 2)

        then:
        parkingSpaceList.size() == 2
        //assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        parkingSpaceService.count() == 5
    }

    void "test delete"() {
        Long parkingSpaceId = setupData()

        expect:
        parkingSpaceService.count() == 5

        when:
        parkingSpaceService.delete(parkingSpaceId)
        sessionFactory.currentSession.flush()

        then:
        parkingSpaceService.count() == 4
    }

    void "test save"() {
        when:
        ParkingSpace parkingSpace = new ParkingSpace(id: '', parkingSpaceOwnerId: '1', latitude: 3.123456, longitude: 3.123456, rating: 2).save(flush: true, failOnError: true)
        parkingSpaceService.save(parkingSpace)

        then:
        parkingSpace.id != null
    }
}
