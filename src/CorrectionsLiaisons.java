public enum CorrectionsLiaisons {
    ᄀᄋ("k"),
    ᄁᄋ("kh"),
    ᄂᄋ("n"),
    ᄃᄋ("t̚"),
    ᄅᄋ("r"),
    ᄆᄋ("m"),
    ᄇᄋ("p̚"),
    ᄀᄒ("k̚"),
    ᄁᄒ("kh"),
    ᄂᄒ("nh"),
    ᄃᄒ("t̚"),
    ᄅᄒ("r"),
    ᄆᄒ("mh"),
    ᄇᄒ("p̚"),
    ᄀᄀ("k̚k̚"),
    ᄂᄀ("nk"),
    ᄃᄀ("t̚k"),
    ᄅᄀ("lk"),
    ᄆᄀ("mk"),
    ᄇᄀ("pk"),
    ᄀᄂ("ŋ"),
    ᄂᄂ("nn"),
    ᄅᄂ("ll"),
    ᄆᄂ("mn"),
    ᄇᄂ("mn"),
    ᄀᄃ("k̚t"),
    ᄂᄃ("nt"),
    ᄃᄃ("t̚t̚"),
    ᄅᄃ("lt"),
    ᄆᄃ("mt"),
    ᄇᄃ("p̚t"),
    ᄀᄅ("kn"),
    ᄂᄅ("ll"),
    ᄅᄅ("ll"),
    ᄆᄅ("mn"),
    ᄇᄅ("mn"),
    ᄀᄆ("km"),
    ᄂᄆ("nm"),
    ᄃᄆ("̚t̚m"),
    ᄅᄆ("lm"),
    ᄆᄆ("mm"),
    ᄇᄆ("mm"),
    ᄀᄇ("kp"),
    ᄇᄇ("p̚p̚"),
    ᄉᄋ("s"),
    ᄊᄋ("s̤"),
    ᄋᄋ("ŋh"),
    ᄌᄋ("t̚tɕʰ"),
    ᄎᄋ("t̚tɕʰ"),
    ᄏᄋ("k̚h"),
    ᄐᄋ("t̚tɕʰ"),
    ᄑᄋ("p̚h"),
    ᄒᄋ("h"),
    ᄉᄒ("t̚"),
    ᄋᄒ("ŋh"),
    ᄌᄒ("t̚tɕʰ"),
    ᄎᄒ("t̚tɕʰ"),
    ᄏᄒ("k̚"),
    ᄐᄒ("t̚"),
    ᄑᄒ("p̚"),
    ᄉᄀ("t̚k"),
    ᄋᄀ("ŋk"),
    ᄌᄀ("t̚k"),
    ᄎᄀ("t̚k"),
    ᄐᄀ("t̚k"),
    ᄑᄀ("p̚k"),
    ᄒᄀ("hk̚"),
    ᄉᄂ("t̚n"),
    ᄊᄂ("nt̚"),
    ᄋᄂ("ŋn"),
    ᄌᄂ("t̚n"),
    ᄎᄂ("t̚n"),
    ᄐᄂ("t̚n"),
    ᄑᄂ("p̚n"),
    ᄒᄂ("hn"),
    ᄉᄃ("t̚t̚"),
    ᄊᄃ("t̚t̚"),
    ᄋᄃ("ŋt"),
    ᄌᄃ("t̚t̚"),
    ᄎᄃ("t̚t̚"),
    ᄏᄃ("k̚t"),
    ᄐᄃ("t̚t̚"),
    ᄑᄃ("p̚t"),
    ᄒᄃ("ht̚"),
    ᄋᄅ("n"),
    ᄒᄅ("r"),
    ᄉᄆ("t̚m"),
    ᄋᄆ("ŋm"),
    ᄌᄆ("t̚m"),
    ᄎᄆ("t̚̚m"),
    ᄏᄆ("k̚t"),
    ᄐᄆ("t̚m"),
    ᄑᄆ("p̚m"),
    ᄒᄆ("hm"),
    ᄉᄇ("t̚p"),
    ᄊᄉ("s̤s"),
    ᄍᄉ("t̚tɕʰ"),
    ᄊᄌ("t̚tɕʰ"),
    ᆪᄋ("ks"),
    ᆬᄋ("ntɕ"),
    ᆭᄋ("lh"),
    ᆰᄋ("lk"),
    ᆱᄋ("lm"),
    ᆲᄋ("lp"),
    ᆳᄋ("ls"),
    ᆴᄋ("ltʰ"),
    ᆵᄋ("lpʰ"),
    ᄚᄋ("lh"),
    ᄡᄋ("p̚s"),
    ᆪᄃ("kt̚"),
    ᆬᄃ("ntɕt"),
    ᆭᄃ("nt̚"),
    ᆰᄃ("kt"),
    ᆱᄃ("mt"),
    ᆲᄃ("pt"),
    ᆳᄃ("lt̚"),
    ᆴᄃ("ltʰ"),
    ᆵᄃ("pʰt"),
    ᄚᄃ("lt̚"),
    ᄡᄃ("p̚t̚"),
    ;

    private final String correction;

    CorrectionsLiaisons(String correction) {
        this.correction = correction;
    }

    public String getCorrection() {
        return correction;
    }
}
