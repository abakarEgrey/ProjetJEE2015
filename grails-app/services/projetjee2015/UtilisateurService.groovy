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
        DemandeVisiteMusee demandeVisiteMusee
        for (Musee m : utilisateur.musees) {
            m.addToDemandesVisites(demandeVisite)
            m.save(flush: true)
            demandeVisite.addToMusees(m)
            demandeVisiteMusee = new DemandeVisiteMusee(dateDemande: new Date(),
                    musee: m,
                    demande: demandeVisite)
            demandeVisiteMusee.save(flush: true)
        }
        utilisateur.addToDemandeDeVisites(demandeVisite)
        utilisateur.save(flush: true)

        demandeVisite.save(flush: true)
    }
}
