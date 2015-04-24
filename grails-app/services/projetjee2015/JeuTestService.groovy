package projetjee2015

import grails.transaction.Transactional

@Transactional
class JeuTestService {

    def createMusee() {
        //Read the CSV file data excluding the header
        /*
        File filecsv = new File("grails-app/assets/Musee.csv")
        new File("iso3166Countries.csv").eachCsvLine { tokens ->
            //parse the csv columns
            def nom= tokens[0].trim()
            def horaireOuvertures= tokens[2].trim()
            def telephone = tokens[4].trim()
            def accesMetro = tokens[5].trim()
            def accesBus = tokens[6].trim()
        }

            //assign the csv column values to domain object
            Musee musee = new Musee() // this is your domain/table that you used to insert csv data

            if(!musee.save(validate: true)){
                musee.errors.each {
                    log.debug(it)
                }
            }
            */

    }
}
