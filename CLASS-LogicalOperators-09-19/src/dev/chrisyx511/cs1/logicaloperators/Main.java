package dev.chrisyx511.cs1.logicaloperators;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /*
        * && AND
        * || OR
        * ! NOT
        * & Check all conditions even if 1st is false
        * */
        boolean a = true;
        boolean b = true;
        System.out.println(a);
        System.out.println(!a);

        Scanner in = new Scanner(System.in);
        String userInputString = in.nextLine();

        char c = userInputString.toLowerCase().charAt(0);
        if (c >= 'a' && c <= 'z') {
            System.out.println("It's a letter!");
            switch (c) {
                case ('a'), ('e'), ('i'), ('o'), ('u') -> System.out.println("Vowel");
                default -> System.out.println("Consonant");
            }
        } else {
            System.out.println("Type better ong-");
        }


    }
}
