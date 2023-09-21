package dev.chrisyx511.cs1.ifelse1;

import java.util.Scanner;

public class BankNotes {
    public static void main(String[] args) {
        // Take and sort user input
        Scanner userInputObject = new Scanner(System.in);
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
        int amountOf1 = (int) (remainder);
        remainder = remainder % 1;
        int amountOf25cent = (int) (remainder/0.25);
        remainder = remainder % 0.25;
        int amountOf10cent = (int) (remainder/0.10);
        remainder = remainder % 0.10;
        int amountOf5cent = (int) (remainder/0.05);
        remainder = remainder % 0.05;

        System.out.printf("%d, %d, %d, %d, %d, %d, %d, %d, %d",
                amountOf100, amountOf50, amountOf20, amountOf10, amountOf5, amountOf1, amountOf25cent, amountOf10cent, amountOf5cent);
        }
}
