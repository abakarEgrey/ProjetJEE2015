package projetjee2015


import spock.lang.*

/**
 *
 */
class JeuTestServiceIntegrationTestSpec extends Specification {

    JeuTestService jeuTestService

    void "test creation jeu de tests pour activités"() {

        given: "une base ne contenant pas de musees"
        Musee.count() == 0

        when: "on crée le jeu de test pour les musees"
        jeuTestService.createMusee()

        then: "13 nouvelles musees ont été crées en base"
        Musee.count() == 20


        when:" des musees exitent deja dans la base"
        Musee.count() == 20

        and:"on déclenche à nouveau la création du jeu de test pour musees"
        jeuTestService.createMusee()

        then:"aucune nouvelle musee n'est crée"
        Musee.count() == 30

    }
}
