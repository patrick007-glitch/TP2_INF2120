import java.util.ArrayList;

/**
 * Classe qui modelise un texte en charactere coreen. Elle cotiens egalement une methode pour traduire le coreen en
 * alphabet phonetique internationale.
 */
public class TexteCoreen {

    protected String texte;
    protected final ArrayList<Hangeul> ListeHangeul = new ArrayList<>();

    /**
     * Construit un ArrayList contenant un hangeul par case avec un string de texte coreen passe en param.
     *
     * @param texte un string non null de charactere coreen.
     */
    public TexteCoreen(String texte) {
        try {

            if (texte != null) {
                this.texte = texte;
                for (int i = 0; i < texte.length(); i++) {
                    ListeHangeul.add(new Hangeul(texte.codePointAt(i)));
                }

            } else {
                System.out.println("Vous n'avez pas entrez de texte");
                System.exit(-1);
            }

        } catch (Exception e) {
            System.out.println("Une erreur innatendu c'est produite.");
        }
    }

    /**
     * Trouve la valeur numerique de la consonne initiale d'un hangeul.
     *
     * @param position l'indice du hangeul dont on veux trouve la consonne initiale.
     * @return la valeur de la consonne initiale du hangeul donne en param.
     */
    public int noConsonneInitiale(int position) {
        return ListeHangeul.get(position).getC();
    }

    /**
     *Trouve la valeur numerique de la voyelle d'un hangeul.
     *
     *@param position l'indice du hangeul dont on veux trouve la consonne initiale.
     *@return la valeur de la voyelle du hangeul donne en param.
     */
    public int noVoyelle(int position) {
        return ListeHangeul.get(position).getV();
    }

    /**
     * Trouve la valeur numerique de la consonne finale d'un hangeul.
     *
     * @param position l'indice du hangeul dont on veux trouve la consonne initiale.
     * @return la valeur de la consonne finale du hangeul donne en param.
     */
    public int noConsonneFinale(int position) {
        return ListeHangeul.get(position).getD();
    }

    /**
     * Prend la representation du texte en charactere coreen et le traduit en charactere de l'alphabet phonetique
     * internationale.
     *
     * @return un string de charactere phonetique international traduit du texte coreen saisi par le constructeur.
     */
    public String traduire() {
        StringBuilder texteTraduit = new StringBuilder();
        Liaisons.ajusterLiaisons2(ListeHangeul);
        for (Hangeul hangeul : ListeHangeul){
            texteTraduit.append(hangeul.getConsoIniIPA()).append(hangeul.getVoyelleIPA()).append(hangeul.getConsoFinaleIPA());
        }
        return texteTraduit.toString();
    }

}







