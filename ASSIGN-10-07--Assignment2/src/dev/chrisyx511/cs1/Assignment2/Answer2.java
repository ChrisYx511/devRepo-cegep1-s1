package dev.chrisyx511.cs1.Assignment2;
/*
 * (Chris) Xi Yang
 * Mehdi Farshid Farzad
 * Introduction to Programming
 * Assignment 2 - Question 2
 *
 * Q2: Capitalize every first letter of every word in a sentence
 * A2:
 * Input: 1 String
 * Output: 1 String
 * */
import java.util.Scanner;

public class Answer2 {
    /**
     * Constant defining a space character
     */
    final private static char SPACE_CHARACTER = ' ';
    public static void main(String[] args) {

        // Get input from user
        final Scanner inputObj = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        final String userSentenceStr = inputObj.nextLine();

        // Capitalize first character and provide sentence for loop to work with
        String outputSentenceStr = userSentenceStr.substring(0,1).toUpperCase() + userSentenceStr.substring(1);

        // Loop through remaining characters of the sentence, capitalizing any character following a space
        for (int i = 1; i < outputSentenceStr.length(); i++) {
            if (checkForPrecedingSpace(outputSentenceStr, i)) {
                outputSentenceStr = outputSentenceStr.substring(0,i) + outputSentenceStr.substring(i, i + 1).toUpperCase() + outputSentenceStr.substring(i + 1);
            }

        }
        // Output the finalized sentence
        System.out.println(outputSentenceStr);

    }
    /**
     * Method to check if the preceding character is a space, returning true if it is a space
     * @param fullString Entire string in which the character is located
     * @param indexOfChar Positive integer representing the index of the character in fullString
     * @return <code>true</code> if the preceding character is a space, <code>false</code> if not
     */
    private static boolean checkForPrecedingSpace(String fullString, int indexOfChar) {
        char precedingChar = fullString.charAt(indexOfChar - 1);
        return (precedingChar == SPACE_CHARACTER);
    }

}
