package bths.csa;

import bths.csa.games.GuessNumber;
import bths.csa.games.HangmanRunner;
import bths.csa.parse.Classifier;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class ParseEngine {
    private Classifier c;

    public ParseEngine() throws IOException {
        c = new Classifier("src/bths/csa/parse/models/");
    }

    public void getReply(String s) {
        s = removePunctuation(s);
        switch (maxC(s)) {
            case "h":
                HangmanRunner hangmanRunner = new HangmanRunner();
                hangmanRunner.PlayHangman();
                break;
            case "g":
                System.out.println("Please pick a number between 0 and 100");
                GuessNumber guessNumber = new GuessNumber(100);
                guessNumber.play();
                break;
            case "greeting":
                int r = ThreadLocalRandom.current().nextInt(0, 6);
                switch (r) {
                    case 0:
                        System.out.println("Hello!");
                        break;
                    case 1:
                        System.out.println("Hi, how are you?");
                        break;
                    case 2:
                        System.out.println("Hi!");
                        break;
                    case 3:
                        System.out.println("Greetings!");
                        break;
                    case 4:
                        System.out.println("Welcome to Magpie!");
                        break;
                    case 5:
                        System.out.println("Hello there!");
                        break;
                }
                break;
            case "mood":
                int r2 = ThreadLocalRandom.current().nextInt(0, 6);
                switch (r2) {
                    case 0:
                        System.out.println("Im doing good, how about you?");
                        break;
                    case 1:
                        System.out.println("I feel sad.");
                        break;
                    case 2:
                        System.out.println("Great!");
                        break;
                    case 3:
                        System.out.println("Fine.");
                        break;
                    case 4:
                        System.out.println("Tired.");
                        break;
                    case 5:
                        System.out.println("Bored.");
                        break;
                }
                break;
            case "unsure":
                System.out.println("I didn't quite understand, can you rephrase that?");
                break;
        }
    }

    private String[] spilt(String in) {
        return in.trim().split("\\s+");
    }

    private String maxC(String s) {
        double minC = .2;

        double h = c.calculateConvergence(spilt(s), "hangman");
        double g = c.calculateConvergence(spilt(s), "guess");
        double greeting = c.calculateConvergence(spilt(s), "hello");
        double mood = c.calculateConvergence(spilt(s), "mood");

        double max1 = Math.max(h, g);
        double max2 = Math.max(greeting, mood);
        double max3 = Math.max(max1, max2);
        if(max3 > minC) {
            if (max3 == h) {
                return "h";
            }
            if (max3 == g) {
                return "g";
            }
            if (max3 == greeting) {
                return "greeting";
            }
            if (max3 == mood) {
                return "mood";
            } else {
                return null;
            }
        }
        else {
            return "unsure";
        }
    }

    private String removePunctuation(String s) {
        s.replace("?", "");
        s.replace(".", "");
        s.replace(",", "");
        s.replace("!", "");
        s.replace("/", "");
        s.replace("#", "");
        s.replace("%", "");
        s.replace("$", "");
        s.replace("&", "");
        s.replace("'", "");
        s.replace("", "");
        s.replace("", "");

        return s;
    }
}
