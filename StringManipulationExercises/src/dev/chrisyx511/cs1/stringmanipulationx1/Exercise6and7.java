package dev.chrisyx511.cs1.stringmanipulationx1;

import java.util.Scanner;

public class Exercise6and7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter string: ");
        String str1 = input.nextLine();

        System.out.println("Lowercase: " + str1.toLowerCase());
        System.out.println("Uppercase: " + str1.toUpperCase());
    }
}
