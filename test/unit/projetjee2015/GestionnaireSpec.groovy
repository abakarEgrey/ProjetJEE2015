package projetjee2015

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Gestionnaire)
class GestionnaireSpec extends Specification {


    @Unroll
    void "test la validite d'un gestionnaire valide"(String unNom, def _) {

        given: "une gestionnaire initialise avec un nom non vide"
        Gestionnaire gestionnaire = new Gestionnaire(nom: unNom)

        expect: "le gestionnaire est valide"
        gestionnaire.validate() == true

        and: "il n'est proprietaire d'aucune musee"
        !gestionnaire.musees

        where:
        unNom    | _
        "un nom" | _

    }

    @Unroll
    void "test l'invalidite d'une gestionnaire non valide"(String unNom, def _) {

        given: "une gestionnaire initialise avec un nom  vide ou sans musee"
        Gestionnaire gestionnaire = new Gestionnaire(nom: "")

        expect: "l'gestionnaire est invalide"
        gestionnaire.validate() == false

        where:
        unNom      | _
        null       | _
        ""         | _
        "un titre" | _

    }


}
