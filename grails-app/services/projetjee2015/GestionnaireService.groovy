package projetjee2015

import grails.transaction.Transactional

@Transactional
class GestionnaireService {
    //rechercher les musees
    List<Musee> searchMusee(String nomMusee, int codePostal, String rueMusee) {
        def musee = Musee.createCriteria()
        def listMusees = musee {
            or {
                like("nom", "%${nomMusee}%")
                adresse {
                    eq("codePostal", codePostal)
                }

                adresse {
                    like("rue", "%${rueMusee}%")
                }

            }
        }
    }
}
