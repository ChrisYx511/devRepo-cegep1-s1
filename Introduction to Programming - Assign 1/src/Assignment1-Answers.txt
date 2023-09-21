/**
 * Xi Yang
 * Mehdi Farshid Farzad
 * Introduction to Programming
 * 16th of September 2023
 * -- Assignment 1 --
 * */
// --------------------------------- //
/*
 * Assignment 1 - Question 1
 *
 * Q1: Find second and fourth occurrence of a letter in a given sentence.
 * A1:
 * Input: 1 String and 1 Char
 * Output: 2 Integers representing Indexes
 * */
import java.util.Scanner;
public class Answer1 {
    public static void main(String[] args) {
        // Take and sort user input
        final Scanner userInputObject = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String userSentence = userInputObject.nextLine();
        System.out.println("Enter an alphabet: ");
        String userFilterString = userInputObject.nextLine();

        // Filter out a singular character from the second input
        char userFilterSingleChar = userFilterString.charAt(0);

        // Find each occurrence
        int firstOccurrenceIndex = userSentence.indexOf(userFilterSingleChar);
        int secondOccurrenceIndex =  userSentence.indexOf(userFilterSingleChar, firstOccurrenceIndex + 1);
        int thirdOccurrenceIndex = userSentence.indexOf(userFilterSingleChar, secondOccurrenceIndex + 1);
        int fourthOccurrenceIndex = userSentence.indexOf(userFilterSingleChar,thirdOccurrenceIndex + 1);

        // Output
        System.out.printf("Second occurrence of letter %c -> index number %d %n",userFilterSingleChar, secondOccurrenceIndex);
        //System.out.println(thirdOccurrenceIndex);
        System.out.printf("Fourth occurrence of letter %c -> index number %d %n",userFilterSingleChar, fourthOccurrenceIndex);

    }
}
// --------------------------------- //
/*
 * Assignment 1 - Question 2
 *
 * Q2: Generate a bill from an entered total
 * A2:
 * Input: 1 Double
 * Output: Strings for layout + 4 Doubles (subtotal, gst, qst, and total)
 * */
import java.util.Scanner;

public class Answer2 {

    public static final double PROVINCIAL_TAX = 0.10;
    public static final double FEDERAL_TAX = 0.05;
    public static void main(String[] args) {
        // Take User Input
        final Scanner userInputObj = new Scanner(System.in);
        System.out.println("Enter the total amount paid: ");
        // Calculations
        double totalAmount = userInputObj.nextDouble();
        double subtotal = returnSubtotal(totalAmount);
        double gst = calculateGSTAmount(subtotal);
        double qst = calculateQSTAmount(subtotal);
        // Output
        System.out.printf("%16s Your bill %n" +
                        "------------------------------------------ %n" +
                        "Original/Selling price: %11s %8.2f %n" +
                        "Amount paid for provincial tax: %s %8.2f %n" +
                        "Amount paid for federal tax:  %5s %8.2f %n" +
                        "------------------------------------------ %n" +
                        "\t\t\t\tTotal price: %s %8.2f"
                , "", "CA$" ,subtotal,"CA$", gst,"CA$" , qst,"CA$" ,totalAmount);
    }

    // Calculate a subtotal from total amount paid
    public static double returnSubtotal(double total) {
        return (total/(1 + FEDERAL_TAX + PROVINCIAL_TAX));
    }
    // Calculate Federal Tax from a Subtotal (price before tax)
    public static double calculateGSTAmount(double subtotal) {
        return (subtotal * FEDERAL_TAX);
    }
    // Calculate Provincial Tax from a Subtotal (price before tax)
    public static double calculateQSTAmount(double subtotal) {
        return (subtotal * PROVINCIAL_TAX);
    }
}
// --------------------------------- //
/*
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
// --------------------------------- //