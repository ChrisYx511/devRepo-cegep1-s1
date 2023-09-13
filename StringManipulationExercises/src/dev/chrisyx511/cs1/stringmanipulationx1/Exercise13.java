package dev.chrisyx511.cs1.stringmanipulationx1;

import java.util.Scanner;

public class Exercise13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter string 1: ");
        String str1 = input.nextLine();
        System.out.print("Enter string 2: ");
        String str2 = input.nextLine();

        System.out.println("Comparison result case sensitive: " + str1.compareTo(str2));
        System.out.println("Comparison result case insensitive: " + str1.compareToIgnoreCase(str2));

    }
}
