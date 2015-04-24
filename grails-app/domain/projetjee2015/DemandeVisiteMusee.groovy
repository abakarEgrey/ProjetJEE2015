package projetjee2015

class DemandeVisiteMusee {
    Date dateDemande;

    static constraints = {
        musees(blank: false, nullable: false)
        demandes(blank: false, nullable: false)
        dateDemande(blank: false, nullable: false)
    }

    static hasMany = [musees: Musee, demandes: DemandeVisite]
}
