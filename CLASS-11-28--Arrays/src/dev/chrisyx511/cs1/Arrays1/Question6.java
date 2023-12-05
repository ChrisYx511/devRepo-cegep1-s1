package dev.chrisyx511.cs1.Arrays1;

import java.util.Arrays;
import java.util.Scanner;

public class Question6 {
    // Shift by one
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        System.out.println("Enter number of entries to be entered: ");
        final int arrLength = in.nextInt();
        int[] userInputNumbers = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            System.out.println("Enter the number corresponding the entry number " + i + ": ");
            userInputNumbers[i] = in.nextInt();
        }
        for (int j = 0; j < arrLength; j++) {
            int temp = userInputNumbers[arrLength - 1];
            int temp2;
            for (int i = 0; i < arrLength; i++) {
                temp2 = userInputNumbers[i];
                userInputNumbers[i] = temp;
                temp = temp2;

            }
            System.out.println(Arrays.toString(userInputNumbers));

        }


    }
}
