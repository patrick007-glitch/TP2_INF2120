public enum CaracAlphabetInternational {

    h ("0068" ) ,
    k ("006B" ) ,
    k̤ ("006B,0324" ) ,
    kʰ("006B,02B0" ) ,
    l ("006C" ) ,
    m ("006D" ) ,
    p ("0070" ) ,
    pʰ("0070,02B0"),
    tʰ("0074,02B0"),
    s ("0073" ) ,
    t ("0074" ) ,
    ŋ ("014B" ) ,
    ɕ ("0255" ) ,
    ɾ ("0255" ) ,
    a ("0061" ) ,
    e ("0065" ) ,
    i ("0069" ) ,
    j ("006A" );

    private final String unicode;

    CaracAlphabetInternational(String unicode) {
        this.unicode = unicode;
    }
}
