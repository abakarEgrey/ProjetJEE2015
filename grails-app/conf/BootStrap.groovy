import projetjee2015.JeuTestService

class BootStrap {

    JeuTestService jeuTestService

    def init = { servletContext ->
        jeuTestService.createMusee()
        jeuTestService.createUser()
    }
    def destroy = {
    }
}
