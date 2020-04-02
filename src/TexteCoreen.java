import java.util.ArrayList;

public class TexteCoreen {

    protected String texte;
    protected final ArrayList<Hangeul> ListeHangeul = new ArrayList<>();

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
        StringBuilder texteTraduit = new StringBuilder();
        Liaisons.ajusterLiaisons(ListeHangeul);
        for (Hangeul hangeul : ListeHangeul){
            texteTraduit.append(hangeul.getConsonneInitiale()).append(hangeul.getVoyelle()).append(hangeul.getConsonneFinale());
        }
        return texteTraduit.toString();
    }

}







