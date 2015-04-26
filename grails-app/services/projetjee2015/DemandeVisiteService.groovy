package projetjee2015

import grails.transaction.Transactional
import org.apache.commons.lang.RandomStringUtils

@Transactional
class DemandeVisiteService {

    DemandeVisite init(DemandeVisite demandeVisite) {
        int randomStringLength = 10
        String charset = (('a'..'z') + ('A'..'Z') + ('0'..'9')).join()
        String randomString = RandomStringUtils.random(randomStringLength, charset.toCharArray())

        while (DemandeVisite.find("from DemandeVisite where code='" + randomString + "'")) {
            randomString = RandomStringUtils.random(randomStringLength, charset.toCharArray())
        }

        demandeVisite.code = randomString
        demandeVisite.status = "En cours de traitement"
        demandeVisite.validate()
        return demandeVisite
    }
}
