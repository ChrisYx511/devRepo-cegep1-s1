package dev.chrisyx511.cs1.loops2;

import java.util.Scanner;

// Do While
public class Exercise4 {
    public static void main(String[] args) {
        final Scanner userInputObj = new Scanner(System.in);
        int count = 1;
        int numberOfEvens = 0;
        int numberOfOdds = 0;
        do {
            System.out.println("Enter number " + count + ":");
            int enteredNumber = userInputObj.nextInt();
            if (enteredNumber % 2 == 0) {
                numberOfEvens++;
            } else {
                numberOfOdds++;
            }
            count++;
        } while (count <= 10);
        System.out.println("Number of odds: " + numberOfOdds);
        System.out.println("Number of evens: " + numberOfEvens);
    }

}
