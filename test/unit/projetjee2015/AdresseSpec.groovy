package projetjee2015

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Adresse)
class AdresseSpec extends Specification {

    @Unroll
    void "test la validite d'une adresse valide"(int unNumero, String uneRue, int unCodePostal, String uneVille) {

        given: "une adresse initialise correctement"
        Adresse adresse = new Adresse(numero: unNumero, rue: uneRue, codePostal: unCodePostal, ville: uneVille)

        expect: "l'adresse est valide"
        adresse.validate() == true

        where:
        unNumero | uneRue              | unCodePostal | uneVille
        118      | "Route de Narbonne" | 31400        | "Toulouse"
        127      | "Rue jean jaures"   | 31000        | "Toulouse"
        118      | "Rue frois verdier" | 31100        | "Toulouse"

    }

    @Unroll
    void "test l'invalidite d'une adresse non valide"(int unNumero, String uneRue, int unCodePostal, String uneVille) {

        given: "un adresse initialise de maniere non valide"
        Adresse adresse = new Adresse(numero: unNumero, rue: uneRue, codePostal: unCodePostal, ville: uneVille)

        expect: "l'adresse est invalide"
        adresse.validate() == false

        where:
        unNumero | uneRue              | unCodePostal | uneVille
        -118     | "Route de Narbonne" | 31400        | "Toulouse"
        127      | ""                  | 31000        | "Toulouse"
        0        | "Rue frois verdier" | -31200       | "Toulouse"
        118      | "Rue frois verdier" | -31200       | ""

    }
}
