package shareparking

class UrlMappings {

    static mappings = {
        /*
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        */
        post "/parkingSpaceOwner/addParkingSpace?"(action: 'addParkingSpace')

        delete "/$controller/$id(.$format)?"(action: 'delete')
        get "/$controller(.$format)?"(action: 'index')
        get "/$controller/$id(.$format)?"(action: 'show')
        post "/$controller(.$format)?"(action: 'save')
        put "/$controller/$id(.$format)?"(action: 'update')
        patch "/$controller/$id(.$format)?"(action: 'patch')


        '/userProfile'(resources: 'userProfile') {
            collection {
                '/search'(controller: 'userProfile', action: 'search')
            }
        }

        '/parkingSpaceOwner'(resources: 'parkingSpaceOwner') {
            collection {
                '/addParkingSpace'(controller: 'parkingSpaceOwner', action: 'addParkingSpace')
            }
        }

        /*
        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
        */
        //'/'(controller: 'UserProfile', action: 'index')
        '500'(view: '/error')
        '404'(view: '/notFound')
    }
}
