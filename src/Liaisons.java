import java.util.ArrayList;

public class Liaisons{

    protected static int indexHangeul(ArrayList<Hangeul> liste, Hangeul hangeul){
        return liste.indexOf(hangeul);
    }

    protected static Hangeul prochainHangeul(ArrayList<Hangeul> liste,Hangeul hangeul){
        Hangeul resultat = null;
        if (liste.indexOf(hangeul) < liste.size() - 1)
            resultat = liste.get(liste.indexOf(hangeul) + 1);
        return resultat;
    }

    protected static String getConsonneIniProchainHangeul(ArrayList<Hangeul> liste, Hangeul hangeul){
        String resultat = null;
        if (prochainHangeul(liste, hangeul) != null){
            resultat = prochainHangeul(liste, hangeul).getConsoIniCoreen();
        }
        return resultat;
    }

    protected static boolean comparerConsoIniProchainHangeul(ArrayList<Hangeul> liste, Hangeul hangeul, String consoComparer){
        boolean resultat = false;
        if (prochainHangeul(liste, hangeul) != null)
            resultat = (getConsonneIniProchainHangeul(liste, hangeul).equals(consoComparer));
        return resultat;
    }

    protected static boolean comparerConsoFinale(Hangeul hangeul, String consoComparer) {
        return (hangeul.getConsoFinaleCoreen().equals(consoComparer));
    }

    protected static void setConsoFinale(Hangeul hangeul,String nouvelleConsoFinale){
        hangeul.setConsonneFinale(nouvelleConsoFinale);
    }

    protected static void setConsoInitProchainHangeul(ArrayList<Hangeul> liste, Hangeul hangeul,String nouvelleConsoIni){
        int index = indexHangeul(liste, hangeul) + 1 ;
        liste.get(index).setConsonneInitiale(nouvelleConsoIni);
    }

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
