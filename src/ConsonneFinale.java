public enum ConsonneFinale {

    w (0, ""),
    ᄀ(1,"k̚"),
    ᄁ(2,"k̚"),
    ᆪ(3,"k"),
    ᄂ(4,"n"),
    ᆬ(5,"ntɕ"),
    ᆭ(6,"nh"),
    ᄃ(7,"t̚"),
    ᄅ(8,"l"),
    ᆰ(9,"k"),ᆱ(10,"m"),
    ᆲ(11,"p"),
    ᆳ(12,"s"),
    ᆴ(13,"tʰ"),
    ᆵ(14,"pʰ"),
    ᄚ(15,"h"),
    ᄆ(16,"m"),
    ᄇ(17,"p̚"),
    ᄡ(18,"p̚"),
    ᄉ(19,"t̚"),
    ᄊ(20,"t̚"),
    ᄋ(21,"ŋ"),
    ᄌ(22,"t̚"),
    ᄎ(23,"t̚"),
    ᄏ(24,"k̚"),
    ᄐ(25,"t̚"),
    ᄑ(26,"p̚"),
    ᄒ(27,"t");

    private final int code;
    private final String IPA;

    ConsonneFinale(int code, String IPA) {
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
