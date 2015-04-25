package projetjee2015

class Musee {

    String nom
    String horairesOuverture
    String telephone
    String accesMetro
    String accesBus
    Gestionnaire gestionnaire
    Adresse adresse

    static constraints = {
        nom(blank: false, nullable: false)
        horairesOuverture(blank: false, nullable: false)
        telephone(blank: false, nullable: false)
        accesMetro(blank: false, nullable: false)
        accesBus(blank: false, nullable: false)
    }
    static hasMany = [demandesVisites: DemandeVisite]

    String toString() {
        return nom;
    }

}
