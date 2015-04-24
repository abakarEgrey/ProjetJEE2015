package projetjee2015

import grails.transaction.Transactional

@Transactional
class JeuTestService {

    def createMusee() {
        //Read the CSV file data excluding the header
        File filecsv = new File("grails-app/assets/Musee.csv")
        filecsv.inputStream.toCsvReader(['skipLines':1]).eachLine { tokens ->
            //parse the csv columns
            /*
            def nom= tokens[0].trim()
            def class= tokens[1].trim()
            def age = tokens[2].trim()
            def phone = tokens[3].trim()
            */
        }

            //assign the csv column values to domain object
            /*
            City city = new City() // this is your domain/table that you used to insert csv data
            city.name = name
            city.class = class
            city.age = age
            if(!city.save(validate: true)){
                city.errors.each {
                    log.debug(it)
                }
            }
            */

    }
}
