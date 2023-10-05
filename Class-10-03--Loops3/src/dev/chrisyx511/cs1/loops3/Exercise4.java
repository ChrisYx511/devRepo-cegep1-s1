package dev.chrisyx511.cs1.loops3;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        final Scanner inputObj = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        final String userStr = inputObj.nextLine();
        String outputString = userStr;
        for (int i = 0; i < outputString.length() - 1; i++) {
            outputString = outputString.substring(0, i) + outputString.charAt(outputString.length() - 1) + outputString.substring(i , outputString.length() - 1);
            System.out.println(outputString);
        }
    }
}
