package shareparking

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ParkingSpaceOwnerServiceSpec extends Specification {

    ParkingSpaceOwnerService parkingSpaceOwnerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        new ParkingSpaceOwner(id: '', userId: '1').save(flush: true, failOnError: true)
        new ParkingSpaceOwner(id: '', userId: '1').save(flush: true, failOnError: true)
        //new ParkingSpaceOwner(...).save(flush: true, failOnError: true)
        //new ParkingSpaceOwner(...).save(flush: true, failOnError: true)
        //ParkingSpaceOwner parkingSpaceOwner = new ParkingSpaceOwner(...).save(flush: true, failOnError: true)
        ParkingSpaceOwner parkingSpaceOwner = new ParkingSpaceOwner(id: '', userId: '1').save(flush: true, failOnError: true)
        new ParkingSpaceOwner(id: '', userId: '1').save(flush: true, failOnError: true)
        new ParkingSpaceOwner(id: '', userId: '1').save(flush: true, failOnError: true)
        //new ParkingSpaceOwner(...).save(flush: true, failOnError: true)
        //new ParkingSpaceOwner(...).save(flush: true, failOnError: true)
        //assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        parkingSpaceOwner.id
    }

    void "test get"() {
        setupData()

        expect:
        parkingSpaceOwnerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ParkingSpaceOwner> parkingSpaceOwnerList = parkingSpaceOwnerService.list(max: 2, offset: 2)

        then:
        parkingSpaceOwnerList.size() == 2
        //assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        parkingSpaceOwnerService.count() == 5
    }

    void "test delete"() {
        Long parkingSpaceOwnerId = setupData()

        expect:
        parkingSpaceOwnerService.count() == 5

        when:
        parkingSpaceOwnerService.delete(parkingSpaceOwnerId)
        sessionFactory.currentSession.flush()

        then:
        parkingSpaceOwnerService.count() == 4
    }

    void "test save"() {
        when:
        ParkingSpaceOwner parkingSpaceOwner = new ParkingSpaceOwner(id: '', userId: '1').save(flush: true, failOnError: true)
        parkingSpaceOwnerService.save(parkingSpaceOwner)

        then:
        parkingSpaceOwner.id != null
    }
}
