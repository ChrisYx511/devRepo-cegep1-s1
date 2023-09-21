package dev.chrisyx511.cs1.assign1;


/*
* (Chris) Xi Yang
* Mehdi Farshid Farzad
* Introduction to Programming
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
