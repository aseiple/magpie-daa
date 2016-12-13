package bths.csa;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RunMagpie {
     public static void main(String[] args) throws FileNotFoundException {
            String response = null;
            ParseEngine parse = new ParseEngine();
            System.out.println("Hello!");
            Scanner sc = new Scanner(System.in);
            response = sc.nextLine();
            System.out.println(parse.getReply(response));
     }
}
