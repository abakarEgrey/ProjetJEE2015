package projetjee2015

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisiteMusee)
class DemandeVisiteMuseeSpec extends Specification {

    @Unroll
    void "test la validite d'une demande de visite musee valide"(Musee unMusee, DemandeVisite uneDemandeVisite,
                                                                 Date uneDateDemande) {

        given:
        "une demande initialise avec un musee, une demande de visite et une date de demande"
        DemandeVisiteMusee demandeVisiteMusee =
                new DemandeVisiteMusee(musee: unMusee, demande: uneDemandeVisite, dateDemande: uneDateDemande)

        expect: "la demande est valide"
        demandeVisiteMusee.validate() == true

        where:
        unMusee     | uneDemandeVisite    | uneDateDemande
        Mock(Musee) | Mock(DemandeVisite) | new Date()

    }

    @Unroll
    void "test l'invalidite d'une demande de visite musee non valide"(Musee unMusee, DemandeVisite uneDemandeVisite,
                                                                      Date uneDateDemande) {

        DemandeVisiteMusee demandeVisiteMusee =
                new DemandeVisiteMusee(musee: unMusee, demande: uneDemandeVisite, dateDemande: uneDateDemande)

        expect: "la demande est invalide"
        demandeVisiteMusee.validate() == false

        where:
        unMusee     | uneDemandeVisite    | uneDateDemande
        null        | Mock(DemandeVisite) | new Date()
        Mock(Musee) | null                | new Date()
        Mock(Musee) | Mock(DemandeVisite) | null

    }
}
