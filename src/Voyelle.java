public enum Voyelle {
    ᅡ(1, "a"),
    ᅢ(2, "ɛ"),
    ᅣ(3, "ja"),
    ᅤ(4, "jɛ"),
    ᅥ(5, "ʌ"),
    ᅦ(6, "e"),
    ᅧ(7, "jʌ"),
    ᅨ(8, "je"),
    ᅩ(9, "o"),
    ᅪ(10, "wa"),
    ᅫ(11, "wɛ"),
    ᅬ(12, "ø"),
    ᅭ(13, "jo"),
    ᅮ(14, "u"),
    ᅯ(15, "wʌ"),
    ᅰ(16, "we"),
    ᅱ(17, "y"),
    ᅲ(18, "ju"),
    ᅳ(19, "ɯ"),
    ᅴ(20, "ɰi"),
    ᅵ(21, "i");


    private final int code;
    private final String IPA;

    Voyelle(int code, String IPA) {
        this.code = code;
        this.IPA = IPA;
    }

    public int getCode() {
        return code;
    }

    public String getIPA() {
        return IPA;
    }
}
