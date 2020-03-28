public class Hangeul extends Object {
    private int uPrime;
    private int d;
    private int v;
    private int c;

    public Hangeul(int u) {
        this.uPrime = u - 44032;
        this.d = this.uPrime % 28;
        this.v = 1 + ( ( uPrime - d ) % 588 ) / 28;
        this.c = 1 + uPrime / 588;
    }

    public int getuPrime() {
        return uPrime;
    }

    public void setuPrime(int uPrime) {
        this.uPrime = uPrime;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

}
