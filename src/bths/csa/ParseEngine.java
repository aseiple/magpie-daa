package bths.csa;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ParseEngine {
    private ParserModel model;
    private Parser parser;

    public ParseEngine() throws FileNotFoundException {
        InputStream modelIn = new FileInputStream("en-parser-chunking.bin");
        try {
            model = new ParserModel(modelIn);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (modelIn != null) {
                try {
                    modelIn.close();
                }
                catch (IOException e) {
                }
            }
        }

        parser = ParserFactory.create(model);
    }

    public String getReply(String in) {
        return parse(in)[0].toString();
    }

    private Parse[] parse(String s) {
        return ParserTool.parseLine(s, parser, 1);
    }
}
