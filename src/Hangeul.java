public class Hangeul {
    private int uPrime;
    private int d;
    private int v;
    private int c;
    public String ConsonneInitiale;
    public String Voyelle;
    public String ConsonneFinale;
    private String consoIniCoreen;
    private String consoFinaleCoreen;

    public Hangeul(int u) {
        this.uPrime = u - 44032;
        this.d = this.uPrime % 28;
        this.v = 1 + ( ( uPrime - d ) % 588 ) / 28;
        this.c = 1+ uPrime / 588;
    }

    public Hangeul( Hangeul hangeul ){
        this.consoIniCoreen = Conversion.trouverCaracCoreenInitiale(hangeul.getC());
        this.consoFinaleCoreen = Conversion.trouverCaracCoreenFinale(hangeul.getD());
        this.ConsonneInitiale = Conversion.trouverConsonneInitiale(hangeul.getC());
        this.Voyelle = Conversion.trouverVoyelle(hangeul.getV());
        this.ConsonneFinale = Conversion.trouverConsonneFinal(hangeul.getD());
    }

    public String getConsonneInitiale() {
        return ConsonneInitiale;
    }

    public void setConsonneInitiale(String consonneInitiale) {
        ConsonneInitiale = consonneInitiale;
    }

    public String getVoyelle() {
        return Voyelle;
    }

    public String getConsonneFinale() {
        return ConsonneFinale;
    }

    public void setConsonneFinale(String consonneFinale) {
        ConsonneFinale = consonneFinale;
    }

    public int getD() {
        return d;
    }

    public int getV() {
        return v;
    }

    public int getC() {
        return c;
    }

    public void setD(int d) {
        this.d = d;
    }

    public void setV(int v) {
        this.v = v;
    }

    public void setC(int c) {
        this.c = c;
    }

    public String getConsoIniCoreen() {
        return consoIniCoreen;
    }

    public String getConsoFinaleCoreen() {
        return consoFinaleCoreen;
    }

    @Override
    public String toString() {
        return ConsonneInitiale
                + Voyelle + ConsonneFinale;
    }
}



