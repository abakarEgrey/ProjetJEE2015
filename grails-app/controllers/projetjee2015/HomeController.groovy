package projetjee2015

import grails.transaction.Transactional

@Transactional(readOnly = true)
class HomeController {

    HomeService homeService
    UtilisateurService utilisateurService

    def index() {

    }

    def doSearchMusee() {
        def museeList = homeService.searchMusee(params.nom, params.int("codePostal"), params.rue)
        render(view: "index", model: [museeInstanceList : museeList,
                                      museeInstanceCount: museeList?.size(),
                                      nomSearch         : params.noms,
                                      codePostalSearch  : params.int("codePostal"),
                                      rueSearch         : params.rue])
    }

    def addFav() {
        utilisateurService.addMuseeToFavorite(Utilisateur.get(1),Musee.get(params.id))
        doSearchMusee()
    }

    def removeFav() {
        utilisateurService.removeMuseeFavorite(Utilisateur.get(1),Musee.get(params.id))
        doSearchMusee()
    }
}
