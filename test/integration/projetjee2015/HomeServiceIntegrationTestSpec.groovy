package projetjee2015



import spock.lang.*

/**
 *
 */
class HomeServiceIntegrationTestSpec extends Specification {
    JeuTestService jeuTestService
    HomeService homeService;
    void "test de la recherche des musees"() {
        List<Musee> museeList = new ArrayList<>()

        given:"nom complete ou partiel de la musee et le code postal"
        String nomMusee = "instrument"
        int codePostal = 31300
        jeuTestService.createMusee()

        when:"quand informations  valides "
        museeList = homeService.searchMusee(nomMusee, codePostal, null)

        then:"on vérife la liste des musees"
        museeList.size() >= 1

        when:"rue complete ou partiel de la musee et le code postal "
        String rue = "saint"
        codePostal = 31000
        museeList = homeService.searchMusee(null, codePostal, rue)

        then:"on vérife la liste des musees"
        museeList.size() == 2

    }
}
