import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class TexteCoreen {

    protected String texte;
    protected ArrayList<Hangeul> ListeHangeul = new ArrayList<>();
    protected Hangeul premier;
    protected Hangeul prochain;
    protected Hangeul precedant;
    protected Hangeul present;
    protected int size;

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



    public int noConsonneInitiale(int position) {
        return ListeHangeul.get(position).getC();
    }

    public int noVoyelle(int position) {
        return ListeHangeul.get(position).getV();
    }

    public int noConsonneFinale(int position) {
        return ListeHangeul.get(position).getD();
    }



    public String traduire() {
        String texteTraduit = "";
        ArrayList<Hangeul> texteAvantAjustement = new ArrayList<>();
        ArrayList<Hangeul> texteApresAjustement;

        for (Hangeul hangeul : ListeHangeul) {
            Hangeul hangeulAvecCharactere = new Hangeul(hangeul);
            texteAvantAjustement.add(hangeulAvecCharactere);
            System.out.println(hangeulAvecCharactere);
        }

        texteApresAjustement = ajusterLiaisons(texteAvantAjustement);
        for (Hangeul hangeul : texteApresAjustement){
            texteTraduit = texteTraduit + hangeul.getConsonneInitiale() + hangeul.getVoyelle() + hangeul.getConsonneFinale();
            System.out.println(texteTraduit);
        }

        return texteTraduit;

    }


    public ArrayList<Hangeul> ajusterLiaisons(ArrayList<Hangeul> texte){

        for (Hangeul hangeul : texte){
            if (hangeul.getConsonneFinale().equals("ᄀ")) {
                if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals( "ᄋ" )){
                    hangeul.setConsonneFinale("k");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄒ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("");
                    hangeul.setConsonneFinale("k̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄀ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("k̚");
                    hangeul.setConsonneFinale("k̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄂ")) {
                    texte.get(texte.indexOf(hangeul) + 1 ).setConsonneInitiale("");
                    hangeul.setConsonneFinale("ŋ");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄃ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("t");
                    hangeul.setConsonneFinale("k̚");
                }else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄅ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("n");
                    hangeul.setConsonneFinale("k");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄆ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("m");
                    hangeul.setConsonneFinale("k");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄇ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("p");
                    hangeul.setConsonneFinale("k");
                }

            } else if ( hangeul.getConsonneFinale().equals("ᄁ")) {
                 if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄋ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("h");
                    hangeul.setConsonneFinale("k");
                 } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄒ")) {
                     texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("h");
                     hangeul.setConsonneFinale("k");
                 }

            } else if ( hangeul.getConsonneFinale().equals("ᄂ")) {
                if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄋ")) {
                    texte.get(texte.indexOf(hangeul) + 1 ).setConsonneInitiale("");
                    hangeul.setConsonneFinale("n");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄒ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("h");
                    hangeul.setConsonneFinale("n");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄀ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("k");
                    hangeul.setConsonneFinale("n");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄂ")) {
                    texte.get(texte.indexOf(hangeul) + 1 ).setConsonneInitiale("n");
                    hangeul.setConsonneFinale("n");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄃ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("t");
                    hangeul.setConsonneFinale("n");
                }else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄅ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("l");
                    hangeul.setConsonneFinale("l");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄆ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("m");
                    hangeul.setConsonneFinale("n");
                }

            } else if ( hangeul.getConsonneFinale().equals("ᄃ")) {
                if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄋ")) {
                    texte.get(texte.indexOf(hangeul) + 1 ).setConsonneInitiale("");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄒ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄀ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("k");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄃ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("t̚");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄆ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("t̚");
                    hangeul.setConsonneFinale("t̚");
                }

            } else if ( hangeul.getConsonneFinale().equals("ᄅ")) {
                if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄋ")) {
                    texte.get(texte.indexOf(hangeul) + 1 ).setConsonneInitiale("");
                    hangeul.setConsonneFinale("r");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄒ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("h");
                    hangeul.setConsonneFinale("r");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄀ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("k");
                    hangeul.setConsonneFinale("l");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄂ")) {
                    texte.get(texte.indexOf(hangeul) + 1 ).setConsonneInitiale("l");
                    hangeul.setConsonneFinale("l");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄃ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("t");
                    hangeul.setConsonneFinale("l");
                }else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄅ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("l");
                    hangeul.setConsonneFinale("l");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄆ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("m");
                    hangeul.setConsonneFinale("l");
                }

            } else if ( hangeul.getConsonneFinale().equals("ᄆ")) {
                if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄋ")) {
                    texte.get(texte.indexOf(hangeul) + 1 ).setConsonneInitiale("");
                    hangeul.setConsonneFinale("m");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄒ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("h");
                    hangeul.setConsonneFinale("m");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄀ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("k");
                    hangeul.setConsonneFinale("m");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄂ")) {
                    texte.get(texte.indexOf(hangeul) + 1 ).setConsonneInitiale("n");
                    hangeul.setConsonneFinale("m");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄃ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("t");
                    hangeul.setConsonneFinale("m");
                }else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄅ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("n");
                    hangeul.setConsonneFinale("m");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄆ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("m");
                    hangeul.setConsonneFinale("m");
                }


            } else if ( hangeul.getConsonneFinale().equals("ᄇ")) {
                if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals( "ᄋ" )){
                    hangeul.setConsonneFinale("p̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄒ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("");
                    hangeul.setConsonneFinale("p̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄀ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("k");
                    hangeul.setConsonneFinale("p");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄂ")) {
                    texte.get(texte.indexOf(hangeul) + 1 ).setConsonneInitiale("n");
                    hangeul.setConsonneFinale("m");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄃ")) {
                    texte.get(texte.indexOf(hangeul )+1).setConsonneInitiale("t");
                    hangeul.setConsonneFinale("p̚");
                }else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄅ")) {
                    texte.get(texte.indexOf(hangeul )+1).setConsonneInitiale("n");
                    hangeul.setConsonneFinale("m");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄆ")) {
                    texte.get(texte.indexOf(hangeul )+1).setConsonneInitiale("m");
                    hangeul.setConsonneFinale("m");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄇ")) {
                    texte.get(texte.indexOf(hangeul )+1).setConsonneInitiale("p̚");
                    hangeul.setConsonneFinale("p̚");
                }


            } else if ( hangeul.getConsonneFinale().equals("ᄉ")) {
                if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals( "ᄋ" )){
                    hangeul.setConsonneFinale("s");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄒ")){
                    texte.get(texte.indexOf(hangeul )+1).setConsonneInitiale("");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄀ")){
                    texte.get(texte.indexOf(hangeul )+1).setConsonneInitiale("k");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄂ")) {
                    texte.get(texte.indexOf(hangeul) + 1 ).setConsonneInitiale("n");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄃ")) {
                    texte.get(texte.indexOf(hangeul )+1).setConsonneInitiale("t");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄆ")) {
                    texte.get(texte.indexOf(hangeul )+1).setConsonneInitiale("m");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄇ")) {
                    texte.get(texte.indexOf(hangeul )+1).setConsonneInitiale("p");
                    hangeul.setConsonneFinale("t̚");
                }
            } else if (hangeul.getConsonneFinale().equals("ᄊ")) {
                if (texte.get(texte.indexOf(hangeul) + 1).getConsonneInitiale().equals("ᄋ")) {
                    hangeul.setConsonneFinale("s̤");
                } else if (texte.get(texte.indexOf(hangeul) + 1).getConsonneInitiale().equals("ᄂ")) {
                    texte.get(texte.indexOf(hangeul) + 1).setConsonneInitiale("n");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1).getConsonneInitiale().equals("ᄃ")) {
                    texte.get(texte.indexOf(hangeul )+1).setConsonneInitiale("t");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1).getConsonneInitiale().equals("ᄉ")) {
                    texte.get(texte.indexOf(hangeul )+1).setConsonneInitiale("p̚");
                    hangeul.setConsonneFinale("p̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1).getConsonneInitiale().equals("ᄌ")) {
                    texte.get(texte.indexOf(hangeul )+1).setConsonneInitiale("p̚");
                    hangeul.setConsonneFinale("p̚");
                }

            } else if (hangeul.getConsonneFinale().equals("ᄋ")) {
                if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals( "ᄋ" )){
                    texte.get(texte.indexOf(hangeul )+1).setConsonneInitiale("h");
                    hangeul.setConsonneFinale("ŋ");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄒ")){
                    texte.get(texte.indexOf(hangeul )+1).setConsonneInitiale("h");
                    hangeul.setConsonneFinale("ŋ");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄀ")){
                    texte.get(texte.indexOf(hangeul) +1).setConsonneInitiale("k");
                    hangeul.setConsonneFinale("ŋ");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄂ")) {
                    texte.get(texte.indexOf(hangeul) + 1 ).setConsonneInitiale("n");
                    hangeul.setConsonneFinale("ŋ");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄃ")) {
                    texte.get(texte.indexOf(hangeul )+1).setConsonneInitiale("t");
                    hangeul.setConsonneFinale("ŋ");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄅ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("");
                    hangeul.setConsonneFinale("n");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄆ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("m");
                    hangeul.setConsonneFinale("ŋ");
                }

            } else if (hangeul.getConsonneFinale().equals("ᄌ") || hangeul.getConsonneFinale().equals("ᄎ")) {
                if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals( "ᄋ" )){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("tɕʰ");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄒ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("tɕʰ");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄀ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("k");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄂ")) {
                    texte.get(texte.indexOf(hangeul) + 1 ).setConsonneInitiale("n");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄃ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("t̚");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄆ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("m");
                    hangeul.setConsonneFinale("t̚");
                }


            } else if (hangeul.getConsonneFinale().equals("ᄏ")) {
                if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals( "ᄋ" )){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("h");
                    hangeul.setConsonneFinale("k̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄒ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("");
                    hangeul.setConsonneFinale("k̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄃ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("t");
                    hangeul.setConsonneFinale("k̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄆ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("t");
                    hangeul.setConsonneFinale("k̚");
                }

            } else if (hangeul.getConsonneFinale().equals("ᄐ")) {
                if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals( "ᄋ" )){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("tɕʰ");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄒ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄀ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("k");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄂ")) {
                    texte.get(texte.indexOf(hangeul) + 1 ).setConsonneInitiale("n");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄃ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("t̚");
                    hangeul.setConsonneFinale("t̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄆ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("m");
                    hangeul.setConsonneFinale("t̚");
                }

            } else if (hangeul.getConsonneFinale().equals("ᄑ")) {
                if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals( "ᄋ" )){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("h");
                    hangeul.setConsonneFinale("p̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄒ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("");
                    hangeul.setConsonneFinale("p̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄀ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("k");
                    hangeul.setConsonneFinale("p̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄂ")) {
                    texte.get(texte.indexOf(hangeul) + 1 ).setConsonneInitiale("n");
                    hangeul.setConsonneFinale("p̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄃ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("t");
                    hangeul.setConsonneFinale("p̚");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄆ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("m");
                    hangeul.setConsonneFinale("p̚");
                }

            } else if (hangeul.getConsonneFinale().equals("ᄒ")) {
                if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals( "ᄋ" )){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("");
                    hangeul.setConsonneFinale("h");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄀ")){
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("k");
                    hangeul.setConsonneFinale("h");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄂ")) {
                    texte.get(texte.indexOf(hangeul) + 1 ).setConsonneInitiale("n");
                    hangeul.setConsonneFinale("h");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄃ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("t");
                    hangeul.setConsonneFinale("h");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄅ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("");
                    hangeul.setConsonneFinale("r");
                } else if (texte.get(texte.indexOf(hangeul) + 1 ).getConsonneInitiale().equals("ᄆ")) {
                    texte.get(texte.indexOf(hangeul)+1).setConsonneInitiale("m");
                    hangeul.setConsonneFinale("h");
                }

            }

        }
        return texte;
    }


}







