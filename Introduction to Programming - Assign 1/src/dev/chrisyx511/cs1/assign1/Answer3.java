package dev.chrisyx511.cs1.assign1;
/*
 * (Chris) Xi Yang
 * Mehdi Farshid Farzad
 * Introduction to Programming
 * Assignment 1 - Question 3
 *
 * Q3: User input a sentence and a character,
 *     remove first and last occurrence
 * A3:
 * Input: 1 String, 1 Char (taken as String)
 * Output: Initial sentence (String) without the first and last occurrence of Char
 * */

import java.util.Scanner;

public class Answer3 {
    public static void main(String[] args) {
        // Take and sort user input
        final Scanner userInputObject = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String userSentence = userInputObject.nextLine();
        System.out.println("Enter an alphabet: ");
        String userFilterString = userInputObject.nextLine();

        // Filter out a singular character from the second input and determine the first and last occurrence
        final String modifiedSentence = getString(userFilterString, userSentence);
        // Output
        System.out.println("Sentence after changes -> " + modifiedSentence);
    }

    // Function that filters out a singular character from the UserFilterString, removes them from userSentence and returns a modified sentence
    private static String getString(String userFilterString, String userSentence) {
        char userFilterSingleChar = userFilterString.charAt(0);
        int indexFirstOccurrence = userSentence.indexOf(userFilterSingleChar);
        int indexLastOccurrence = userSentence.lastIndexOf(userFilterSingleChar);

        // Create modified sentence
        return userSentence.substring(0,indexFirstOccurrence) + userSentence.substring(indexFirstOccurrence + 1, indexLastOccurrence) + userSentence.substring(indexLastOccurrence +1);
    }
}
