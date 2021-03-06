package projetjee2015

import grails.transaction.Transactional

@Transactional
class HomeService {

    //rechercher les musees
    List<Musee> searchMusee(String nomMusee, int codePostal, String rueMusee) {
        def musee = Musee.createCriteria()
        def listMusees = musee {
            if (nomMusee) {
                System.out.println("nomMusee.Min = " + nomMusee.toLowerCase())
                like("nom", "%${nomMusee.toUpperCase()}%")
            }
            if (codePostal) {
                adresse {
                    eq("codePostal", codePostal)
                }
            }
            if (rueMusee) {
                adresse {
                    like("rue", "%${rueMusee.toUpperCase()}%")
                }
            }
        }
    }
}