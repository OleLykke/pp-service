package shareparking

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ParkingSpaceController {

    ParkingSpaceService parkingSpaceService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond parkingSpaceService.list(params), model:[parkingSpaceCount: parkingSpaceService.count()]
    }

    def show(Long id) {
        respond parkingSpaceService.get(id)
    }

    def create() {
        respond new ParkingSpace(params)
    }

    def save(ParkingSpace parkingSpace) {
        if (parkingSpace == null) {
            notFound()
            return
        }

        try {
            parkingSpaceService.save(parkingSpace)
        } catch (ValidationException e) {
            respond parkingSpace.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'parkingSpace.label', default: 'ParkingSpace'), parkingSpace.id])
                redirect parkingSpace
            }
            '*' { respond parkingSpace, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond parkingSpaceService.get(id)
    }

    def update(ParkingSpace parkingSpace) {
        if (parkingSpace == null) {
            notFound()
            return
        }

        try {
            parkingSpaceService.save(parkingSpace)
        } catch (ValidationException e) {
            respond parkingSpace.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'parkingSpace.label', default: 'ParkingSpace'), parkingSpace.id])
                redirect parkingSpace
            }
            '*'{ respond parkingSpace, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        parkingSpaceService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'parkingSpace.label', default: 'ParkingSpace'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'parkingSpace.label', default: 'ParkingSpace'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
