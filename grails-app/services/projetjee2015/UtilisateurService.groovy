package projetjee2015

import grails.transaction.Transactional

@Transactional
class UtilisateurService {

    def serviceMethod() {

    }

    def addMuseeToFavorite(Utilisateur utilisateur, Musee musee) {
        utilisateur.addToMusees(musee)
        utilisateur.save(flush: true)
    }

    def removeMuseeFavorite(Utilisateur utilisateur, Musee musee) {
        utilisateur.removeFromMusees(musee)
        utilisateur.save(flush: true)
    }

    def addDemandeVisite(Utilisateur utilisateur, DemandeVisite demandeVisite) {
        utilisateur.addToDemandeDeVisites(demandeVisite)
        utilisateur.save(flush: true)
    }
}
