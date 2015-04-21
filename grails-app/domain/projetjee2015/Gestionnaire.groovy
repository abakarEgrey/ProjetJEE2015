package projetjee2015

class Gestionnaire {

    String nom

    static hasMany = [musees : Musee]

    static constraints = {
        nom blank: false
    }
}
