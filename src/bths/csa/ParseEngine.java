package bths.csa;

import bths.csa.parse.Classifier;
import java.io.IOException;

public class ParseEngine {
    private Classifier c;

    public ParseEngine() throws IOException {
        c = new Classifier("src/bths/csa/parse/models/");
    }

    public String getReply(String s) {
        double h = c.calculateConvergence(spilt(s), "hangman");
        double g = c.calculateConvergence(spilt(s), "guess");
        String r;
        if(h > g) {
            r = "hangman";
        }
        else {
            r = "guess my number";
        }
        return "I think you are trying to play " + r;
    }

    private String[] spilt(String in) {
        return in.trim().split("\\s+");
    }
}
