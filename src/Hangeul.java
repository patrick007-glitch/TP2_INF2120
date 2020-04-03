public class Hangeul {
    /**
     * Classe qui modelise un hangeul c'est a dire un charactere coreen qui est compose de 3 jamos qui sont egalement
     * characteres coreens. Il construit un hangeul a l'aide du hangeul coreen et contiens les valeurs en integer des
     * codes representant chaque jamo ainsi que la representation en charactere de l'alphabet phonetique internationale
     * des jamos ainsi que la representation en characteres coreens de la consonne finale et initale.
     * Pour trouver u il est necessaire d'utiliser la methode codepointsat() sur un hangeul coreen.
     */

    private int uPrime;
    private int d;
    private int v;
    private int c;
    public String consoIniIPA;
    public String voyelleIPA;
    public String consoFinaleIPA;
    private String consoIniCoreen;
    private String consoFinaleCoreen;
    private String consoFinConsoIniCoreen;

    /**
     * Construit un hangeul a l'aide du hangeul coreen
     * et contien les valeurs en integer des codes representant chaque jamo. d est la consonne finale du jamo. c est la
     * consonne initale d'un jamo et v est la voyelle entre la consonne initiale et finale. Uprime sert seulement a
     * trouver les codes et u doit etre passer en param pour calculer les autres attributs. Pour trouver u il faut
     * utiliser la methode codepointsat() sur un hangeul coreen pour passe la valeur en integer a l'exterieur de la
     * classe. Puis le constructeur se sert des valeurs numeriques pour trouver les correspondances en characteres de
     * l'alphabet phonetique internationale ainsi que des jamos en charactere coreen.
     *
     * @param u valeur numerique d'un hangeul coreen trouve avec la methode codepointsat().
     */
    public Hangeul(int u) {
        this.uPrime = u - 44032;
        this.d = this.uPrime % 28;
        this.v = 1 + ( ( uPrime - d ) % 588 ) / 28;
        this.c = 1+ uPrime / 588;
        this.consoIniCoreen = Conversion.trouverCaracCoreenInitiale(c);
        this.consoFinaleCoreen = Conversion.trouverCaracCoreenFinale(d);
        this.consoIniIPA = Conversion.trouverConsonneInitiale(c);
        this.voyelleIPA = Conversion.trouverVoyelle(v);
        this.consoFinaleIPA = Conversion.trouverConsonneFinal(d);
    }

    public String getConsoIniIPA() {
        return consoIniIPA;
    }

    public void setConsoIniIPA(String consoIniIPA) {
        this.consoIniIPA = consoIniIPA;
    }

    public String getVoyelleIPA() {
        return voyelleIPA;
    }

    public String getConsoFinaleIPA() {
        return consoFinaleIPA;
    }

    public void setConsoFinaleIPA(String consoFinaleIPA) {
        this.consoFinaleIPA = consoFinaleIPA;
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

    public String getConsoIniCoreen() {
        return consoIniCoreen;
    }

    public String getConsoFinaleCoreen() {
        return consoFinaleCoreen;
    }

    @Override
    public String toString() {
        return consoIniIPA
                + voyelleIPA + consoFinaleIPA;
    }
}



