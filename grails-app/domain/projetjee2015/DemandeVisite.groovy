package projetjee2015

class DemandeVisite {
    String code
    Date dateDebutPeriode
    Date dateFinPeriode
    int nbPersonne
    String status

    static hasMany = [musees: Musee]

    static belongsTo = [Musee]

    static constraints = {
        code(blank: false, nullable: false)
        dateDebutPeriode(blank: false, nullable: false)
        dateFinPeriode(blank: false, nullable: false, validator: { val, obj ->

            ( obj.dateDebutPeriode != null && val?.after(obj.dateDebutPeriode))

        })
        status(blank: false, nullable: false)
        nbPersonne(min: 1)

    }


}
