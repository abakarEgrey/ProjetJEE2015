package projetjee2015


import spock.lang.*

/**
 *
 */
class UtilisateurServiceIntegrationTestSpec extends Specification {

    UtilisateurService utilisateurService;

    void "test removeMuseeFavorite"() {
        List<Musee> museeList = new ArrayList<>()
        given: "Un utilisateur et musee "
        Adresse uneAdresse = new Adresse(numero: 2, rue: "RUE DES ARCHIVES", codePostal: 31500, ville: "TOULOUSE")
        Musee uneMusee =
                new Musee(nom: "ARCHIVES MUNICIPALES TOULOUSE",
                        horairesOuverture: "Ouvert du lundi au vendredi de 9h à 17h. Fermeture de 12h à 13h30 pendant toutes les vacances scolaires. Fermeture annuelle la dernière quinzaine de juillet.",
                        telephone: "05 61 61 63 33",
                        accesMetro: "Roseraie (A)", accesBus: "36, 38", gestionnaire: Mock(Gestionnaire),
                        adresse: uneAdresse)

        Utilisateur unUtilisateur = new Utilisateur(nom: "DUPONT", prenom: "Pascal", email: "dupont_pascal@email.fr", sexe: "M", dateNaissance: new Date(1972, 6, 17))
        museeList.add(uneMusee)
        unUtilisateur.musees = museeList;

        when: "quand on veut supprmier une musée de la liste des favories de l'utilisateur "
        unUtilisateur = utilisateurService.removeMuseeFavorite(unUtilisateur, uneMusee)


        then: "on verifie la suppression effective de la musée "
        !unUtilisateur.musees.contains(uneMusee)

    }

    void "test addToFavorite"() {
        List<Musee> museeList = new ArrayList<>()
        given: "Un utilisateur et musee "
        Adresse uneAdresse = new Adresse(numero: 2, rue: "RUE DES ARCHIVES", codePostal: 31500, ville: "TOULOUSE")
        Musee uneMusee =
                new Musee(nom: "ARCHIVES MUNICIPALES TOULOUSE",
                        horairesOuverture: "Ouvert du lundi au vendredi de 9h à 17h. Fermeture de 12h à 13h30 pendant toutes les vacances scolaires. Fermeture annuelle la dernière quinzaine de juillet.",
                        telephone: "05 61 61 63 33",
                        accesMetro: "Roseraie (A)", accesBus: "36, 38", gestionnaire: Mock(Gestionnaire),
                        adresse: uneAdresse)

        Utilisateur unUtilisateur = new Utilisateur(nom: "DUPONT", prenom: "Pascal", email: "dupont_pascal@email.fr", sexe: "M", dateNaissance: new Date(1972, 6, 17))
        unUtilisateur.musees = museeList;
        !unUtilisateur.musees.contains(uneMusee)

        when: "quand on ajoute la liste de musées  favories de l'utilisateur "
        unUtilisateur = utilisateurService.addMuseeToFavorite(unUtilisateur, uneMusee)


        then: "on verifie l'ajout effectif de la musée "
        unUtilisateur.musees.contains(uneMusee)

    }

    void "test addDemandeVisite"() {
        List<Musee> museeList = new ArrayList<>()
        given: "Un utilisateur et demandeVisite "
        Adresse uneAdresse = new Adresse(numero: 2, rue: "RUE DES ARCHIVES", codePostal: 31500, ville: "TOULOUSE")
        Adresse uneAdresse1 = new Adresse(numero: 5, rue: "RUE SAINT PANTALEON", codePostal: 31000, ville: "TOULOUSE")
        Musee uneMusee =
                new Musee(nom: "ARCHIVES MUNICIPALES TOULOUSE",
                        horairesOuverture: "Ouvert du lundi au vendredi de 9h à 17h. Fermeture de 12h à 13h30 pendant toutes les vacances scolaires. Fermeture annuelle la dernière quinzaine de juillet.",
                        telephone: "05 61 61 63 33",
                        accesMetro: "Roseraie (A)", accesBus: "36, 38", gestionnaire: Mock(Gestionnaire),
                        adresse: uneAdresse)

        Musee uneMusee1 =
                new Musee(nom: "CMAV - CENTRE MERIDIONAL DE L'ARCHITECTURE DE LA VILLE",
                        horairesOuverture: "Ouvert du mardi au samedi de 13h à 19hfermé les dimanches, jours fériés et du 1er au 15 août",
                        telephone: "05 61 23 30 49",
                        accesMetro: "Capitole (A), Jean Jaurès (B)", accesBus: "ncv, 2, 10, 12, 14, 38, 78 et 80", gestionnaire: Mock(Gestionnaire),
                        adresse: uneAdresse1)

        Utilisateur unUtilisateur = new Utilisateur(nom: "DUPONT", prenom: "Pascal", email: "dupont_pascal@email.fr", sexe: "M", dateNaissance: new Date(1972, 6, 17))
        museeList.add(uneMusee)
        museeList.add(uneMusee1)
        unUtilisateur.musees = museeList;
        Date debutDate = new Date(2015,04,26);
        Date finDate = new Date(2015, 04, 30);
        DemandeVisite demandeVisite =  new DemandeVisite(code: "1", dateDebutPeriode: debutDate, dateFinPeriode: finDate, nbPersonne: 3, status: "En cours de traitement")


        when: "quand on effectue la demande de visite "
        demandeVisite = utilisateurService.addDemandeVisite(unUtilisateur, demandeVisite)
        unUtilisateur.demandeDeVisites.contains(demandeVisite)
        demandeVisite.validate()


        then: "on verifie l'ajout effectif de la musée "
        unUtilisateur.musees.contains(uneMusee)

    }
}
