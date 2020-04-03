import java.util.ArrayList;

/**
 * Classe qui contiens les regles d'ajustement pour des hangeuls en coreens. Il est possible d'utiliser soit des
 * characteres de l'alphabet international ou de l'alphabet coreen selon l'implementation desirer cependant il faut
 * modifier la classe en consequence.
 */
public class Liaisons {

    /**
     * Trouve l'index du hangeul donne en parametre dans l'ArrayList donne en parametre.
     *
     * @param liste   un ArrayList de hangeuls
     * @param hangeul un objet de type hangeul (voir la classe hangeul) dont on veux trouver la position.
     * @return un int representant l'index du hangeul en param.
     */
    protected static int indexHangeul(ArrayList<Hangeul> liste, Hangeul hangeul) {
        return liste.indexOf(hangeul);
    }

    /**
     * Trouve et renvoie le prochain hangeul apres le hangeul donner en parametre dans l'ArrayList passer en param.
     *
     * @param liste   un ArrayList de hangeuls
     * @param hangeul un objet de type hangeul (voir la classe hangeul) que l'on veux trouver.
     * @return le hangeul suivant dans la liste de hangeul
     */
    protected static Hangeul prochainHangeul(ArrayList<Hangeul> liste, Hangeul hangeul) {
        Hangeul resultat = null;
        if (liste.indexOf(hangeul) < liste.size() - 1)
            resultat = liste.get(liste.indexOf(hangeul) + 1);
        return resultat;
    }

    /**
     * Trouve la consonne initale du hangeul suivant le hangeul passe en param dans un ArrayList de hangeul aussi donne
     * en param.
     *
     * @param liste   un ArrayList de hangeuls.
     * @param hangeul sert de reference dans l'ArrayList pour trouver le hangeul suivant.
     * @return un String ui est la consonne initiale du hangeul suivant celui en param.
     */
    protected static String getConsonneIniProchainHangeul(ArrayList<Hangeul> liste, Hangeul hangeul) {
        String resultat = null;
        if (prochainHangeul(liste, hangeul) != null) {
            resultat = prochainHangeul(liste, hangeul).getConsoIniCoreen();
        }
        return resultat;
    }

    /**
     * Modifie la derniere consonne qui compose le hangeul passe en param. Il est possible de
     * modifier la classe au besoin pour utiliser soit des characteres de l'alphabet phonetique internationale ou des
     * characteres coreens selon la preference d'implementation du programmeur.
     *
     * @param hangeul             le hangeul qui sera modifie.
     * @param nouvelleConsoFinale un String de la consonne initiale d'un hangeul en alphabet phonetique
     *                            international ou en charactere coreen selon l'implementation du programmeur.
     */
    protected static void setConsoFinale(Hangeul hangeul, String nouvelleConsoFinale) {
        hangeul.setConsoFinaleIPA(nouvelleConsoFinale);
    }

    /**
     * Modifie la premiere consonne qui compose le hangeul suivant le hangeul passe en param. Il est possible de
     * modifier la classe au besoin pour utiliser soit des characteres de l'alphabet phonetique internationale ou des
     * characteres coreens selon la preference d'implementation du programmeur.
     *
     * @param liste            un ArrayList de hangeuls.
     * @param hangeul          sert de reference dans l'ArrayList pour trouver le hangeul suivant.
     * @param nouvelleConsoIni un String de la nouvelle consonne initiale d'un hangeul en alphabet phonetique
     *                         international ou en charactere coreen selon l'implementation du programmeur.
     */
    protected static void setConsoInitProchainHangeul(ArrayList<Hangeul> liste, Hangeul hangeul, String nouvelleConsoIni) {
        int index = indexHangeul(liste, hangeul) + 1;
        liste.get(index).setConsoIniIPA(nouvelleConsoIni);
    }

    /**
     * Concatene le charactere coreen finale du hangeul en param et le premier charactere du hangeul suivant celui en
     * param.
     *
     * @param liste   un ArrayList de hangeuls.
     * @param hangeul sert de reference dans l'ArrayList pour trouver le hangeul suivant.
     * @return le charactere coreen finale du hangeul en param et le premier charactere du hangeul suivant celui en
     * param concatener ensemble.
     */
    protected static String getConsoFinConsoIniCoreen(ArrayList<Hangeul> liste, Hangeul hangeul) {
        return hangeul.getConsoFinaleCoreen() + getConsonneIniProchainHangeul(liste, hangeul);
    }

    /**
     * Itere tout les hangeuls dans un ArrayList de hangeul et verifie si chaque consonne final d'un hangeul et la
     * consonne initiale du hangeul suivant ont besoin d'etre modifier pour respecter les regles du language coreen.
     *
     * @param liste un ArrayList de hangeul
     */
    public static void ajusterLiaisons(ArrayList<Hangeul> liste) {
        for (Hangeul hangeul : liste) {
            if (Conversion.appliquerLiaisons(getConsoFinConsoIniCoreen(liste, hangeul))) {
                setConsoFinale(hangeul, Conversion.trouverCorrections(getConsoFinConsoIniCoreen(liste, hangeul)));
                setConsoInitProchainHangeul(liste, hangeul, "");
            }
        }
    }

}
