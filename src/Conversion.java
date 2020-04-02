/**
 * Classe qui contiens les methodes servant a acceder au valeurs dans les enumerations Voyelle, ConsonneInitiale et
 * ConsonneFinale. Elle se sert de code representant les jamos(charactere coreens) qui doivent etre trouve a l'aide de
 * calcul soit : uPrime = u - 44032;
 *               d = uPrime % 28;
 *               v = 1 + ( ( uPrime - d ) % 588 ) / 28;
 *               c = 1+ uPrime / 588;
 * C'est calculs sont implementer dans la classe Hangeul.
 */
public class Conversion {

    /**
     * Trouve le charactere de l'alphabet phonetique international a partir d'un integer representant le code d'un
     * chararctere coreen(jamo).
     * Cette methode est utiliser pour trouver la consonne initiale d'un hangeul.
     *
     * @param position un integer representant le code d'un jamo.
     * @return un String representant l'equivalant du jamo en charactere phonetique international.
     */
    public static String trouverConsonneInitiale( int position ){
        String resultat = null;
        for (ConsonneInitiale consonne : ConsonneInitiale.values()) {
            if (position == consonne.getCode()){
                resultat = consonne.getIPA();
            }
        }
        return resultat;
    }

    /**
     * Trouve le charactere de l'alphabet phonetique international a partir d'un integer representant le code d'un
     * chararctere coreen(jamo).
     * Cette methode est utiliser pour trouver la consonne finale d'un hangeul.
     *
     * @param position un integer representant le code d'un jamo.
     * @return un String representant l'equivalant du jamo en charactere phonetique international.
     */
    public static String trouverConsonneFinal( int position ){
        String resultat = null;
        for (ConsonneFinale consonne : ConsonneFinale.values()) {
            if (position == consonne.getCode()){
                resultat = consonne.getIPA();
            }
        }
        return resultat;
    }

    /**
     * Trouve le charactere de l'alphabet phonetique international a partir d'un integer representant le code d'un
     * chararctere coreen(jamo).
     * Cette methode est utilise pour trouver les voyelles.
     *
     * @param position un integer representant le code d'un jamo.
     * @return un String representant l'equivalant du jamo en charactere phonetique international.
     */
    public static String trouverVoyelle( int position ){
        String resultat = "";
        for (Voyelle voyelle : Voyelle.values()) {
            if (position == voyelle.getCode()){
                resultat = voyelle.getIPA();
            }
        }
        return resultat;
    }

    /**
     * Trouve le premier charactere coreen d'un hangeul a partir d'un integer representant le code du
     * jamo.
     *
     * @param position un integer representant le code d'un jamo.
     * @return un String representant l'equivalant du jamo en charactere phonetique international.
     */
    public static String trouverCaracCoreenInitiale( int position){
        String resultat = "";
        for (ConsonneInitiale consonne : ConsonneInitiale.values()) {
            if (position == consonne.getCode()){
                resultat = consonne.name();
            }
        }
        return resultat;
    }

    /**
     * Trouve le charactere coreen finale d'un hangeul a partir d'un integer representant le code du
     * jamo.
     *
     * @param position un integer representant le code d'un jamo.
     * @return un String representant l'equivalant du jamo en charactere phonetique international.
     */
    public static String trouverCaracCoreenFinale( int position){
        String resultat = "";
        for (ConsonneFinale consonne : ConsonneFinale.values()) {
            if (position == consonne.getCode()){
                resultat = consonne.name();
            }
        }
        return resultat;
    }
}

