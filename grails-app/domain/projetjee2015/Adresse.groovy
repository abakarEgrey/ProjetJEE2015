package projetjee2015

class Adresse {

    int numero
    String rue
    int codePostal
    String ville

    static constraints = {
        numero min: 0
        codePostal min: 0
    }
}
