package projetjee2015

import grails.transaction.Transactional

@Transactional
class UtilisateurService {

    def serviceMethod() {

    }

    def addMuseeToFavorite(Utilisateur utilisateur, Musee musee) {
        Utilisateur utilisateur1 = utilisateur
        utilisateur1.addToMusees(musee)
        utilisateur1.save(flush: true)
    }

    def removeMuseeFavorite(Utilisateur utilisateur, Musee musee) {
        Utilisateur utilisateur1 = utilisateur
        utilisateur1.removeFromMusees(musee)
        utilisateur1.save(flush: true)
    }
}
