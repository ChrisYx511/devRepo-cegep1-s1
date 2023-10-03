package dev.chrisyx511.cs1.ifelse1;

import java.util.Scanner;

public class BankNotes {
    public static void main(String[] args) {
        // Take and sort user input
        final Scanner userInputObject = new Scanner(System.in);
        System.out.println("Enter an amount: ");
        double userAmount = userInputObject.nextDouble();

        int amountOf100 = (int) (userAmount / 100);
        double remainder = userAmount % 100;
        int amountOf50 = (int) (remainder/50);
        remainder = remainder % 50;
        int amountOf20 = (int) (remainder/20);
        remainder = remainder % 20;
        int amountOf10 = (int) (remainder/10);
        remainder = remainder % 10;
        int amountOf5 = (int) (remainder/5);
        remainder = remainder % 5;
        int amountOf2 = (int) (remainder/2);
        remainder = remainder % 2;
        int amountOf1 = (int) (remainder);
        remainder = remainder % 1;
        int amountOf25cent = (int) (remainder/0.25);
        remainder = remainder % 0.25;
        int amountOf10cent = (int) (remainder/0.10);
        remainder = remainder % 0.10;
        int amountOf5cent = (int) (remainder/0.05);
        remainder = remainder % 0.05;
        if (remainder > 0.025) {
            amountOf5cent++;
        }

        System.out.printf("$100 notes: %d,%n $50 Notes: %d,%n $20 Notes: %d,%n $10 Notes: %d,%n $5 Notes: %d,%n $2 Coin: %d,%n $1 Coin: %d,%n 25-Cent Coin: %d,%n 10-Cent Coin: %d,%n 5-Cent Coin: %d %n",
                amountOf100, amountOf50, amountOf20, amountOf10, amountOf5, amountOf2, amountOf1, amountOf25cent, amountOf10cent, amountOf5cent);
        userInputObject.close();

    }

}
