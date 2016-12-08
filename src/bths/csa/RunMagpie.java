package bths.csa;

import java.util.Scanner;

public class RunMagpie {
    public static void main(String[] args) {
        String response = null;
        Parser parse = new Parser();
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello!");
        while (!response.toLowerCase().equals("bye")) {
            response = sc.nextLine();
            System.out.println(parse.getReply(response));
        }
    }
}
