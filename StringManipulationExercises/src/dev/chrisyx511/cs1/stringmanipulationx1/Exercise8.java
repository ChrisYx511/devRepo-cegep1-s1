package dev.chrisyx511.cs1.stringmanipulationx1;

import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter string 1: ");
        String str1 = input.nextLine();
        System.out.println("Result: "+ str1.trim());
    }
}
