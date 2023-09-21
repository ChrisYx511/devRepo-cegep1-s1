package dev.chrisyx511.cs1.stringmanipulationx1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println("The length of the string is: " + str.length());

    }
}
