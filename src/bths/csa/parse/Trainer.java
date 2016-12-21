package bths.csa.parse;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by August on 12/21/2016.
 */
public class Trainer {
    private static String dir = "src/bths/csa/parse/models/";
    private static String currentModel;
    private static Map<String, Integer> model = new HashMap<String, Integer>();
    private static File modelFile;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What model would you like to work on?");
        currentModel = scanner.nextLine().toLowerCase() + ".txt";

        if(new File(dir + currentModel).exists()) {
            modelFile = new File(dir + currentModel);
            loadCurrentModel();
        }

        String line = "";
        while(!line.equals("end")) {
            line = scanner.nextLine().toLowerCase();
            if(!line.equals("end")) {
                addTrainingLine(line);
            }
        }
        writeModelToFile();
    }

    private static void loadCurrentModel() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(modelFile));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String word = line.trim().split("\\s+")[0];
            int weight = Integer.parseInt(line.trim().split("\\s+")[1]);
            model.put(word, weight);
        }
    }

    private static void addTrainingLine(String line) {
        String[] lines = line.split("\\s+");
        for(String word : lines) {
            Integer oldCount = model.get(word);
            if(oldCount == null) {
                oldCount = 0;
            }
            model.put(word, oldCount + 1);
        }
    }

    private static void writeModelToFile() throws IOException {
        List<String> lines= new ArrayList<>();

        for(String s : model.keySet()) {
            lines.add(s + " " + model.get(s));
        }
        Path file = Paths.get(dir + currentModel);
        Files.write(file, lines, Charset.forName("UTF-8"));
    }
}
