public enum consonneIni {

    ᄀ(1, "k"),
    ᄁ(2,"k̤"),
    ᄂ̤(3,"n"),
    ᄃ(4,"t"),
    ᄄ5(5,"t̤"),
    ᄅ(6,"ɾ"),
    ᄆ(7,"m"),
    ᄇ(8,"p"),
    ᄈ(9,"p̤"),
    ᄉ(10,"s"),
    ᄊ(11,"s̤") ,
    ᄋ(12, " "),
    ᄌ(13,"tɕ"),
    ᄍ(14, "t̤ɕ"),
    ᄎ(15,"tɕʰ"),
    ᄏ(16,"kʰ"),
    ᄐ(17, "tʰ"),
    ᄑ(18,"pʰ"),
    ᄒ(19,"h");

    private final int code;
    private final String IPA;

    consonneIni(int code, String IPA) {
        this.code = code;
        this.IPA = IPA;
    }
}