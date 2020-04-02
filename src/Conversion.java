public class Conversion {

    public  static String trouverConsonneInitiale( int position ){
        String resultat = null;
        for (ConsonneInitiale consonne : ConsonneInitiale.values()) {
            if (position == consonne.getCode()){
                resultat = consonne.getIPA();
            }
        }
        return resultat;
    }

    public  static String trouverConsonneFinal( int position ){
        String resultat = null;
        for (ConsonneFinale consonne : ConsonneFinale.values()) {
            if (position == consonne.getCode()){
                resultat = consonne.getIPA();
            }
        }
        return resultat;
    }

    public  static String trouverVoyelle( int position ){
        String resultat = "";
        for (Voyelle voyelle : Voyelle.values()) {
            if (position == voyelle.getCode()){
                resultat = voyelle.getIPA();
            }
        }
        return resultat;
    }

    public static String trouverCaracCoreenInitiale( int position){
        String resultat = "";
        for (ConsonneInitiale consonne : ConsonneInitiale.values()) {
            if (position == consonne.getCode()){
                resultat = consonne.name();
            }
        }
        return resultat;
    }

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

