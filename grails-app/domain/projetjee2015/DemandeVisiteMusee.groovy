package projetjee2015

class DemandeVisiteMusee {
    Date dateDemande;
    Musee musee
    DemandeVisite demande

    static constraints = {
        musee(blank: false, nullable: false)
        demande(blank: false, nullable: false)
        dateDemande(blank: false, nullable: false)
    }
}
