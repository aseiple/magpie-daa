package bths.csa;


import java.io.IOException;
import java.util.Scanner;

public class RunMagpie {
     public static void main(String[] args) throws IOException {
         ParseEngine pe = new ParseEngine();
         Scanner scanner = new Scanner(System.in);
         String line = "";
         boolean r = true;
         while (!line.equals(r)) {
             line = scanner.nextLine().toLowerCase();
             if (line.equals("bye")) {
                 r = false;
             }
             else {
                 pe.getReply(line);
             }
         }
     }
}
