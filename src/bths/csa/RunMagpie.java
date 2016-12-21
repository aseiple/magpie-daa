package bths.csa;


import java.io.IOException;
import java.util.Scanner;

public class RunMagpie {
     public static void main(String[] args) throws IOException {
//            String response = null;
//            ParseEngine parse = new ParseEngine();
//            System.out.println("Hello!");
//            Scanner sc = new Scanner(System.in);
//            response = sc.nextLine();
//            System.out.println(parse.getReply(response));


         ParseEngine pe = new ParseEngine();
         Scanner scanner = new Scanner(System.in);
         System.out.println(pe.getReply(scanner.nextLine()));
     }
}
