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
        System.out.println(Utilisateur.get(1).nom + " " + Musee.get(params.id).nom);
        utilisateurService.addMuseeToFavorite(Utilisateur.get(1),Musee.get(params.id))
        doSearchMusee()
        //render(view: "index", model: [museeInstanceList: params.museeList, museeInstanceCount: params.museeList.size()]);

    }
}
