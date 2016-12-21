package bths.csa;

import bths.csa.parse.Classifier;
import java.io.IOException;

public class ParseEngine {
    private Classifier c;

    public ParseEngine() throws IOException {
        c = new Classifier("src/bths/csa/parse/models/");
    }

    public double getReply(String s) {
        return c.calculateConvergence(spilt(s), "hangman");
    }

    private String[] spilt(String in) {
        return in.trim().split("\\s+");
    }
}
