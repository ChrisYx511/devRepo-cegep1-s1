package dev.chrisyx511.cs1.Arrays1;

import java.util.Scanner;

public class Question1 {
    // Array Palindrome
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        System.out.println("Enter number of entries to be entered: ");
        final int arrLength = in.nextInt();
        int[] userInputNumbers = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            System.out.println("Enter the number corresponding the entry number " + i + ": ");
            userInputNumbers[i] = in.nextInt();
        }
        if (checkArrayPalindrome(userInputNumbers)) {
            System.out.println("Entries form a palindrome!");

        } else {
            System.out.println("Entries do not form a palindrome.");
        }
    }

    static boolean checkArrayPalindrome(int[] arr) {
        for (int i = 0,j = arr.length - 1; i < j  ; i++, j--) {
            if (arr[i] != arr[j]) {
                return false;
            }
        }
        return true;
    }

}
