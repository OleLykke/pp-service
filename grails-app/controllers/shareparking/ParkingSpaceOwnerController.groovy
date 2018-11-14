package shareparking

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ParkingSpaceOwnerController {

    ParkingSpaceOwnerService parkingSpaceOwnerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond parkingSpaceOwnerService.list(params), model:[parkingSpaceOwnerCount: parkingSpaceOwnerService.count()]
    }

    def show(Long id) {
        respond parkingSpaceOwnerService.get(id)
    }

    def create() {
        respond new ParkingSpaceOwner(params)
    }

    def save(ParkingSpaceOwner parkingSpaceOwner) {
        if (parkingSpaceOwner == null) {
            notFound()
            return
        }

        try {
            parkingSpaceOwnerService.save(parkingSpaceOwner)
        } catch (ValidationException e) {
            respond parkingSpaceOwner.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'parkingSpaceOwner.label', default: 'ParkingSpaceOwner'), parkingSpaceOwner.id])
                redirect parkingSpaceOwner
            }
            '*' { respond parkingSpaceOwner, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond parkingSpaceOwnerService.get(id)
    }

    def update(ParkingSpaceOwner parkingSpaceOwner) {
        if (parkingSpaceOwner == null) {
            notFound()
            return
        }

        try {
            parkingSpaceOwnerService.save(parkingSpaceOwner)
        } catch (ValidationException e) {
            respond parkingSpaceOwner.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'parkingSpaceOwner.label', default: 'ParkingSpaceOwner'), parkingSpaceOwner.id])
                redirect parkingSpaceOwner
            }
            '*'{ respond parkingSpaceOwner, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        parkingSpaceOwnerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'parkingSpaceOwner.label', default: 'ParkingSpaceOwner'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'parkingSpaceOwner.label', default: 'ParkingSpaceOwner'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
