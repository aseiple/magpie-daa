package bths.csa.parse;

import java.io.*;
import java.util.*;

/**
 * Created by August on 12/19/2016.
 */
public class Classifier {
    public Map<String, WeightedToken[]> models = new HashMap<String, WeightedToken[]>();

    public Classifier(String dir) throws IOException {
        File[] files = new File(dir).listFiles();
        for(File f : files) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line;
            List<WeightedToken> tokens = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                String word = line.trim().split("\\s+")[0];
                int weight = Integer.parseInt(line.trim().split("\\s+")[1]);
                tokens.add(new WeightedToken(word, weight));
            }
            WeightedToken[] tkns = new WeightedToken[tokens.size()];
            tokens.toArray(tkns);
            models.put(f.getName().substring(0, f.getName().length()-4), tkns);
            bufferedReader.close();
        }
    }

    public double calculateConvergence(String[] input, String model) {
        WeightedToken[] reference = models.get(model);
        double inputWeight = 0;
        double targetWeight = 0;
        for (WeightedToken token : reference) {
            targetWeight += token.getWeight();
            for (String s : input) {
                if(s.equals(token.getWord())) {
                    inputWeight += token.getWeight();
                }
            }
        }
        return inputWeight / targetWeight;
    }
}
