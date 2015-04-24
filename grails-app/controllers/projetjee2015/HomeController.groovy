package projetjee2015

class HomeController {

    HomeService homeService

    def index() {

    }

    def doSearchMusee() {
        def museeList = homeService.searchMusee(params.nom, params.int("codePostal"), params.rue)
        render(view: "index", model: [museeInstanceList: museeList])
    }
}
