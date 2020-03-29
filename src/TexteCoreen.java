import java.util.ArrayList;

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
                this.premier = ListeHangeul.get(0);
                this.present = premier;
                this.prochain = ListeHangeul.get(ListeHangeul.indexOf(present) + 1);
                this.precedant = null;
                this.size = ListeHangeul.size();
            } else {
                System.out.println("Vous n'avez pas entrez de texte");
                System.exit(-1);
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Une erreur c'est produite.");
        }
    }
    public void next() {
        if (hasNext())
            prochain = ListeHangeul.get(ListeHangeul.indexOf(present) + 1);
        precedant = present;
        present = prochain;
        if (hasNext())
            prochain = ListeHangeul.get(ListeHangeul.indexOf(present) + 1);
    }

    public boolean hasNext() {
        boolean hasnext = true;
        if (ListeHangeul.indexOf(present) >= size - 1) {
            hasnext = false;
        }
        return hasnext;
    }

    public int noConsonneInitiale(int position) {
        return present.getC();
    }

    public int noVoyelle(int position) {
        return present.getV();
    }

    public int noConsonneFinale(int position) {
        return present.getD();
    }

    public String traduire() {
        String noString = "string";
        for (Hangeul hangeul : ListeHangeul) {

        }
        return noString;
    }





}







