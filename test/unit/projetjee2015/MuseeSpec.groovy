package projetjee2015

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Musee)
class MuseeSpec extends Specification {

    @Unroll
    void "test la validite d'un musee valide"(String unNom, String desHoraires, String unTelephone,
                                              String unAccesMetro, String unAccesBus,
                                              Gestionnaire unGestionnaire, Adresse uneAdresse) {

        given:
        "un musee initialise avec un nom non vide, des horaires, un telephone, un acces metro, " +
                "et un acces bus"
        Musee musee =
                new Musee(nom: unNom, horairesOuverture: desHoraires, telephone: unTelephone,
                        accesMetro: unAccesMetro, accesBus: unAccesBus, gestionnaire: unGestionnaire,
                        adresse: uneAdresse)

        expect: "le musee est valide"
        musee.validate() == true

        and: "il ne possède aucune demande de visite"
        !musee.demandesVisites


        where:
        unNom                    | desHoraires | unTelephone  | unAccesMetro                | unAccesBus      | unGestionnaire     | uneAdresse
        "Musee de l'Agriculture" | "8h - 19h"  | "0102030405" | "Metro: A - Arret Chatelet" | "Bus: 78,79,01" | Mock(Gestionnaire) | Mock(projetjee2015.Adresse)

    }

    @Unroll
    void "test l' invalidite d'un musee valide"(String unNom, String desHoraires, String unTelephone,
                                                String unAccesMetro, String unAccesBus) {

        Musee musee =
                new Musee(nom: unNom, horairesOuverture: desHoraires, telephone: unTelephone, accesMetro: unAccesMetro,
                        accesBus: unAccesBus)

        expect: "le musee est invalide"
        musee.validate() == false

        where:
        unNom                    | desHoraires | unTelephone  | unAccesMetro                | unAccesBus
        null                     | "8h - 19h"  | "0102030405" | "Metro: A - Arret Chatelet" | "Bus: 78,79,01"
        "Musee de l'Agriculture" | null        | "0102030405" | "Metro: A - Arret Chatelet" | "Bus: 78,79,01"
        "Musee de l'Agriculture" | "8h - 19h"  | null         | "Metro: A - Arret Chatelet" | "Bus: 78,79,01"
        "Musee de l'Agriculture" | "8h - 19h"  | "0102030405" | null                        | "Bus: 78,79,01"
        "Musee de l'Agriculture" | "8h - 19h"  | "0102030405" | "Metro: A - Arret Chatelet" | null

    }

    @Unroll
    void "test toString"() {
        given:
        Musee musee = new Musee(nom: "unMusee")

        when:
        def museeToString = musee.toString()

        then:
        museeToString == "unMusee"
    }

}
