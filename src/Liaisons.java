import java.util.ArrayList;

/**
 * Classe qui contiens les regles d'ajustement pour des hangeuls en coreens. Il est possible d'utiliser soit des
 * characteres de l'alphabet international ou de l'alphabet coreen selon l'implementation desirer cependant il faut
 * modifier la classe en consequence.
 */
public class Liaisons{

    /**
     * Trouve l'index du hangeul donne en parametre dans l'ArrayList donne en parametre.
     * @param liste un ArrayList de hangeuls
     * @param hangeul un objet de type hangeul (voir la classe hangeul) dont on veux trouver la position.
     * @return un int representant l'index du hangeul en param.
     */
    protected static int indexHangeul(ArrayList<Hangeul> liste, Hangeul hangeul){
        return liste.indexOf(hangeul);
    }

    /**
     * Trouve et renvoie le prochain hangeul apres le hangeul donner en parametre dans l'ArrayList passer en param.
     * @param liste  un ArrayList de hangeuls
     * @param hangeul un objet de type hangeul (voir la classe hangeul) que l'on veux trouver.
     * @return le hangeul suivant dans la liste de hangeul
     */
    protected static Hangeul prochainHangeul(ArrayList<Hangeul> liste,Hangeul hangeul){
        Hangeul resultat = null;
        if (liste.indexOf(hangeul) < liste.size() - 1)
            resultat = liste.get(liste.indexOf(hangeul) + 1);
        return resultat;
    }

    /**
     * Trouve la consonne initale du hangeul suivant le hangeul passe en param dans un ArrayList de hangeul aussi donne
     * en param.
     * @param liste un ArrayList de hangeuls.
     * @param hangeul sert de reference dans l'ArrayList pour trouver le hangeul suivant.
     * @return un String ui est la consonne initiale du hangeul suivant celui en param.
     */
    protected static String getConsonneIniProchainHangeul(ArrayList<Hangeul> liste, Hangeul hangeul){
        String resultat = null;
        if (prochainHangeul(liste, hangeul) != null){
            resultat = prochainHangeul(liste, hangeul).getConsoIniCoreen();
        }
        return resultat;
    }

    /**
     *Compare la premiere consonne du hangeul suivant le hangeul passer en param avec le String passe en param. Il est
     * possible de modifier la classe au besoin pour utiliser soit des characteres de l'alphabet phonetique
     * internationale ou des characteres coreens selon la preference d'implementation du programmeur.
     * @param liste un ArrayList de hangeuls.
     * @param hangeul sert de reference dans l'ArrayList pour trouver le hangeul suivant.
     * @param consoComparer String auxquels on veux comparer la consonne initiale du hangeul  suivant le hangeul donne
     *                      en param soit en alphabet phonetique international ou en charactere coreen selon
     *                      l'implementation du programmeur.
     * @return true si la consonne est la meme (attention a l'implementation choisi) false sinon.
     */
    protected static boolean comparerConsoIniProchainHangeul(ArrayList<Hangeul> liste, Hangeul hangeul, String consoComparer){
        boolean resultat = false;
        if (prochainHangeul(liste, hangeul) != null)
            resultat = (getConsonneIniProchainHangeul(liste, hangeul).equals(consoComparer));
        return resultat;
    }

    /**
     * Compare la derniere consonne d'un hangeul avec le String passe en param. Il Il est possible de
     * modifier la classe au besoin pour utiliser soit des characteres de l'alphabet phonetique internationale ou des
     * characteres coreens selon la preference d'implementation du programmeur.
     * @param hangeul le hangeul qui servira a la comparaison.
     * @param consoComparer String auxquels on veux comparer la consonne finale d'un hangeul en alphabet phonetique
     *                      international ou en charactere coreen selon l'implementation du programmeur.
     * @return true si la consonne est la meme (attention a l'implementation choisi) false sinon.
     */
    protected static boolean comparerConsoFinale(Hangeul hangeul, String consoComparer) {
        return (hangeul.getConsoFinaleCoreen().equals(consoComparer));
    }

    /**
     * Modifie la derniere consonne qui compose le hangeul passe en param. Il est possible de
     * modifier la classe au besoin pour utiliser soit des characteres de l'alphabet phonetique internationale ou des
     * characteres coreens selon la preference d'implementation du programmeur.
     * @param hangeul le hangeul qui sera modifie.
     * @param nouvelleConsoFinale un String de la consonne initiale d'un hangeul en alphabet phonetique
     *                            international ou en charactere coreen selon l'implementation du programmeur.
     */
    protected static void setConsoFinale(Hangeul hangeul,String nouvelleConsoFinale){
        hangeul.setConsonneFinale(nouvelleConsoFinale);
    }

    /**
     * Modifie la premiere consonne qui compose le hangeul suivant le hangeul passe en param. Il est possible de
     * modifier la classe au besoin pour utiliser soit des characteres de l'alphabet phonetique internationale ou des
     * characteres coreens selon la preference d'implementation du programmeur.
     * @param liste un ArrayList de hangeuls.
     * @param hangeul sert de reference dans l'ArrayList pour trouver le hangeul suivant.
     * @param nouvelleConsoIni un String de la nouvelle consonne initiale d'un hangeul en alphabet phonetique
     *                        international ou en charactere coreen selon l'implementation du programmeur.
     */
    protected static void setConsoInitProchainHangeul(ArrayList<Hangeul> liste, Hangeul hangeul,String nouvelleConsoIni){
        int index = indexHangeul(liste, hangeul) + 1 ;
        liste.get(index).setConsonneInitiale(nouvelleConsoIni);
    }

    /**
     * Itere tout les hangeuls dans un ArrayList de hangeul et verifie si chaque consonne final d'un hangeul et la
     * consonne initiale du hangeul suivant ont besoin d'etre modifier pour respecter les regles du language coreen.
     * @param liste un ArrayList de hangeul
     * @return l'ArrayList passer en param avec les modifications.
     */
    public static ArrayList<Hangeul> ajusterLiaisons(ArrayList<Hangeul> liste) {
        for (Hangeul hangeul : liste) {
            if (comparerConsoFinale(hangeul,"ᄀ")) {
                if (comparerConsoIniProchainHangeul(liste, hangeul,"")) {
                    setConsoFinale(hangeul,"k");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄒ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"");
                    setConsoFinale(hangeul,"k̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄀ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"k̚");
                    setConsoFinale(hangeul,"k̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄂ")) {
                    setConsoInitProchainHangeul( liste, hangeul,"");
                    setConsoFinale(hangeul,"ŋ");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄃ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"t");
                    setConsoFinale(hangeul,"k̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄅ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"n");
                    setConsoFinale(hangeul,"k");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄆ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"m");
                    setConsoFinale(hangeul,"k");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄇ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"p");
                    setConsoFinale(hangeul,"k");
                }

            } else if (comparerConsoFinale(hangeul,"ᄁ")) {
                if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄋ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"h");
                    hangeul.setConsonneFinale("k");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄒ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"h");
                    hangeul.setConsonneFinale("k");
                }

            } else if (comparerConsoFinale(hangeul,"ᄂ")) {
                if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄋ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"");
                    hangeul.setConsonneFinale("n");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄒ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"h");
                    hangeul.setConsonneFinale("n");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄀ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"k");
                    hangeul.setConsonneFinale("n");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄂ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"n");
                    hangeul.setConsonneFinale("n");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄃ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"t");
                    hangeul.setConsonneFinale("n");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄅ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"l");
                    hangeul.setConsonneFinale("l");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄆ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"m");
                    hangeul.setConsonneFinale("n");
                }

            } else if (comparerConsoFinale(hangeul,"ᄃ")) {
                if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄋ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄒ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄀ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"k");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄃ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"t̚");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄆ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"t̚");
                    hangeul.setConsonneFinale("t̚");
                }

            } else if (comparerConsoFinale(hangeul,"ᄅ")) {
                if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄋ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"");
                    hangeul.setConsonneFinale("r");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄒ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"h");
                    hangeul.setConsonneFinale("r");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄀ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"k");
                    hangeul.setConsonneFinale("l");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄂ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"l");
                    hangeul.setConsonneFinale("l");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄃ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"t");
                    hangeul.setConsonneFinale("l");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄅ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"l");
                    hangeul.setConsonneFinale("l");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄆ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"m");
                    hangeul.setConsonneFinale("l");
                }

            } else if (comparerConsoFinale(hangeul,"ᄆ")) {
                if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄋ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"");
                    hangeul.setConsonneFinale("m");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄒ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"h");
                    hangeul.setConsonneFinale("m");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄀ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"k");
                    hangeul.setConsonneFinale("m");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄂ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"n");
                    hangeul.setConsonneFinale("m");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄃ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"t");
                    hangeul.setConsonneFinale("m");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄅ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"n");
                    hangeul.setConsonneFinale("m");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄆ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"m");
                    hangeul.setConsonneFinale("m");
                }


            } else if (comparerConsoFinale(hangeul,"ᄇ")) {
                if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄋ")) {
                    hangeul.setConsonneFinale("p̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄒ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"");
                    hangeul.setConsonneFinale("p̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄀ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"k");
                    hangeul.setConsonneFinale("p");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄂ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"n");
                    hangeul.setConsonneFinale("m");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄃ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"t");
                    hangeul.setConsonneFinale("p̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄅ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"n");
                    hangeul.setConsonneFinale("m");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄆ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"m");
                    hangeul.setConsonneFinale("m");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄇ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"p̚");
                    hangeul.setConsonneFinale("p̚");
                }


            } else if (comparerConsoFinale(hangeul,"ᄉ")) {
                if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄋ")) {
                    hangeul.setConsonneFinale("s");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄒ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄀ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"k");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄂ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"n");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄃ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"t");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄆ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"m");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄇ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"p");
                    hangeul.setConsonneFinale("t̚");
                }
            } else if (comparerConsoFinale(hangeul,"ᄊ")) {
                if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄋ")) {
                    hangeul.setConsonneFinale("s̤");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄂ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"t̚");
                    hangeul.setConsonneFinale("n");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄃ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"t");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄉ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"p̚");
                    hangeul.setConsonneFinale("p̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄌ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"p̚");
                    hangeul.setConsonneFinale("p̚");
                }

            } else if (comparerConsoFinale(hangeul,"ᄋ")) {
                if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄋ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"h");
                    hangeul.setConsonneFinale("ŋ");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄒ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"h");
                    hangeul.setConsonneFinale("ŋ");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄀ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"k");
                    hangeul.setConsonneFinale("ŋ");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄂ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"n");
                    hangeul.setConsonneFinale("ŋ");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄃ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"t");
                    hangeul.setConsonneFinale("ŋ");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄅ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"");
                    hangeul.setConsonneFinale("n");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄆ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"m");
                    hangeul.setConsonneFinale("ŋ");
                }

            } else if (comparerConsoFinale(hangeul,"ᄌ") || comparerConsoFinale(hangeul,"ᄎ")) {
                if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄋ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"tɕʰ");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄒ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"tɕʰ");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄀ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"k");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄂ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"n");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄃ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"t̚");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄆ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"m");
                    hangeul.setConsonneFinale("t̚");
                }


            } else if (comparerConsoFinale(hangeul,"ᄏ")) {
                if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄋ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"h");
                    hangeul.setConsonneFinale("k̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄒ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"");
                    hangeul.setConsonneFinale("k̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄃ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"t");
                    hangeul.setConsonneFinale("k̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄆ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"t");
                    hangeul.setConsonneFinale("k̚");
                }

            } else if (comparerConsoFinale(hangeul,"ᄐ")) {
                if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄋ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"tɕʰ");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄒ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄀ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"k");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄂ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"n");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄃ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"t̚");
                    hangeul.setConsonneFinale("t̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄆ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"m");
                    hangeul.setConsonneFinale("t̚");
                }

            } else if (comparerConsoFinale(hangeul,"ᄑ")) {
                if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄋ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"h");
                    hangeul.setConsonneFinale("p̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄒ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"");
                    hangeul.setConsonneFinale("p̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄀ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"k");
                    hangeul.setConsonneFinale("p̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄂ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"n");
                    hangeul.setConsonneFinale("p̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄃ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"t");
                    hangeul.setConsonneFinale("p̚");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄆ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"m");
                    hangeul.setConsonneFinale("p̚");
                }

            } else if (comparerConsoFinale(hangeul,"ᄒ")) {
                if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄋ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"");
                    hangeul.setConsonneFinale("h");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄀ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"k");
                    hangeul.setConsonneFinale("h");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄂ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"n");
                    hangeul.setConsonneFinale("h");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄃ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"t");
                    hangeul.setConsonneFinale("h");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄅ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"");
                    hangeul.setConsonneFinale("r");
                } else if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄆ")) {
                    setConsoInitProchainHangeul(liste, hangeul,"m");
                    hangeul.setConsonneFinale("h");
                }

            } else if (comparerConsoFinale(hangeul,"ᄡ")) {
                if (comparerConsoIniProchainHangeul(liste, hangeul,"ᄋ")){
                    setConsoInitProchainHangeul(liste, hangeul,"s");
                    hangeul.setConsonneFinale("p̚");
                }
            }

        }
        return liste;
    }

}
