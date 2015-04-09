package projetjee2015

class Utilisateur {

    String nom
    String prenom
    String email
    String sexe
    Date dateNaissance


    static hasMany = [musees: Musee, demandeDeVisites: DemandeVisite]

    static constraints = {
        nom blank: false
        prenom blank: false
        email email: true
        sexe inList: ["M", "F"]
        dateNaissance nullable: true
    }
}
