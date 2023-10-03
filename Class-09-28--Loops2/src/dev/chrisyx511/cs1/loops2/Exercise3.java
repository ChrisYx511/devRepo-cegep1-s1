package dev.chrisyx511.cs1.loops2;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        final Scanner userInputObj = new Scanner(System.in);
        System.out.println("Enter number:");
        int base = userInputObj.nextInt();
        int oddResult = 0;
        int evenResult = 0;
        while (base >= 1) {
            int currentDigit = base % 10;
            if (currentDigit % 2 == 0) {
                evenResult += currentDigit;
            } else {
                oddResult += currentDigit;
            }
            base = base / 10;
        }
        System.out.println("Odd: " + oddResult );
        System.out.println("Even: " + evenResult);

    }
}
