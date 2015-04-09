package projetjee2015

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisite)
class DemandeVisiteSpec extends Specification {

    @Unroll
    void "test la validite d'une demande de visite valide"(String unCode, Date uneDateDebut, Date uneDateFin,
                                                           int unNbPersonne, String unStatus, Musee unMusee) {

        given:
        "une demande initialise avec un code non vide, une date de debut, une date de fin, un nombre de personnes," +
                " et un status non vide"
        DemandeVisite demandeVisite =
                new DemandeVisite(code: unCode, dateDebutPeriode: uneDateDebut,
                        dateFinPeriode: uneDateFin, nbPersonne: unNbPersonne, status: unStatus, musees: unMusee)

        expect: "le musée est valide"
        demandeVisite.validate() == true

        and: "elle concerne au moins un musee"
        demandeVisite.musees.size() > 0


        where:
        unCode  | uneDateDebut           | uneDateFin             | unNbPersonne | unStatus                 | unMusee
        "01234" | new Date(2015, 03, 25) | new Date(2015, 03, 30) | 1            | "En cours de traitement" | Mock(Musee)

    }

    @Unroll
    void "test l'invalidite d'une demande de visite non valide"(String unCode, Date uneDateDebut, Date uneDateFin,
                                                                int unNbPersonne, String unStatus) {

        DemandeVisite demandeVisite =
                new DemandeVisite(code: unCode, dateDebutPeriode: uneDateDebut,
                        dateFinPeriode: uneDateFin, nbPersonne: unNbPersonne, status: unStatus)

        expect: "la demande est invalide"
        demandeVisite.validate() == false

        where:
        unCode  | uneDateDebut           | uneDateFin             | unNbPersonne | unStatus
        null    | new Date(2015, 03, 25) | new Date(2015, 03, 30) | 1            | "En cours de traitement"
        "01234" | null                   | new Date(2015, 03, 30) | 1            | "En cours de traitement"
        "01234" | new Date(2015, 03, 25) | null                   | 1            | "En cours de traitement"
        "01234" | new Date(2015, 03, 25) | new Date(2015, 03, 30) | 0            | "En cours de traitement"
        "01234" | new Date(2015, 03, 25) | new Date(2015, 03, 30) | 1            | null
        "01234" | new Date(2015, 03, 25) | new Date(2015, 03, 30) | 1            | ""
        "01234" | new Date(2015, 03, 25) | new Date(2015, 03, 20) | 1            | "En cours de traitement"

    }
}
