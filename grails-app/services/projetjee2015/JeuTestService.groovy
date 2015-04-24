package projetjee2015

import grails.transaction.Transactional

@Transactional
class JeuTestService {

    def createMusee() {
        //Read the CSV file data excluding the header
        Adresse uneAdresse
        Musee unMusee
        Gestionnaire theGestionnaire = new Gestionnaire(nom: "Gestionnaire")
        theGestionnaire.save()
        File filecsv = new File("grails-app/assets/Musee.csv")
        filecsv.eachLine(1) { tokens ->
            tokens.splitEachLine(";") { line ->
                def unNom = line[0].trim()
                def uneHoraireOuvertures = line[2].trim()
                def unTelephone = line[4].trim()
                def unAccesMetro = line[5].trim()
                def unAccesBus = line[6].trim()
                def unNumero = line[7].trim()
                def uneRue = line[8].trim()
                def unCodePostal = line[9].trim()
                def uneVille = line[10].trim()
                uneAdresse = new Adresse(numero: unNumero, rue: uneRue,
                        codePostal: unCodePostal, ville: uneVille)
                uneAdresse.save(flush: true)

                unMusee = new Musee(nom: unNom, horairesOuverture: uneHoraireOuvertures,
                        telephone: unTelephone, accesMetro: unAccesMetro,
                        accesBus: unAccesBus, adresse: uneAdresse.getId(),
                        gestionnaire: theGestionnaire)
                unMusee.save(flush: true)
            }

        }
    }

    def createUser() {
        Utilisateur utilisateur = new Utilisateur(nom: "LeGros",
                prenom: "Roger",
                email: "legrosroger@roberto.com",
                sexe: "M",
                dateNaissance: new Date(1980, 01, 01))
        utilisateur.save()
    }
}
