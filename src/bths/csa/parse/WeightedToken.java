package bths.csa.parse;

/**
 * Created by August on 12/19/2016.
 */
public class WeightedToken {
    private String word;
    private int weight;

    public WeightedToken(String word, int weight) {
        this.word = word;
        this.weight = weight;
    }

    public String getWord() {
        return word;
    }

    public int getWeight() {
        return weight;
    }
}
