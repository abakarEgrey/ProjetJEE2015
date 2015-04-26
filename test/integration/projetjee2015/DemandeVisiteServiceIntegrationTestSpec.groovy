package projetjee2015


import spock.lang.*

/**
 *
 */
class DemandeVisiteServiceIntegrationTestSpec extends Specification {
    DemandeVisiteService demandeVisiteService
    DemandeVisite demandeVisite
    JeuTestService jeuTestService
    HomeController homeController
    def setup() {
    }

    def cleanup() {
    }

    void "test d'utilisation de demande de sevice"() {
        List<Musee> museeList = new ArrayList<>()
        given:"les musees preferees fournis dans le jeu de test "
        Adresse uneAdresse = new Adresse(numero: 2, rue: "RUE DES ARCHIVES", codePostal: 31500, ville: "TOULOUSE")
        Musee musee =
                new Musee(nom: "ARCHIVES MUNICIPALES TOULOUSE",
                        horairesOuverture: "Ouvert du lundi au vendredi de 9h à 17h. Fermeture de 12h à 13h30 pendant toutes les vacances scolaires. Fermeture annuelle la dernière quinzaine de juillet.",
                        telephone: "05 61 61 63 33",
                        accesMetro: "Roseraie (A)", accesBus: "36, 38", gestionnaire: Mock(Gestionnaire),
                        adresse: uneAdresse)

        when:"quand informations formulaire non valides "
        Date debutDate = new Date(2015,04,26);
        Date finDate = new Date(2015, 04, 30);
        demandeVisite =  new DemandeVisite(code: "1", dateDebutPeriode: debutDate, dateFinPeriode: finDate, nbPersonne: 3, status: "demande de traitement")
        museeList.add(musee)
        demandeVisite.musees = museeList;
        demandeVisiteService.init(demandeVisite)

        then:"on récupere les informations saisies pour la demande de visite et comparer "
        demandeVisite.code != "1"
        demandeVisite.status == "En cours de traitement"
        demandeVisite.validate() == true

    }
}
