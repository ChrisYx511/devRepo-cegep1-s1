package dev.chrisyx511.cs1.Assignment2;
/*
 * (Chris) Xi Yang
 * Mehdi Farshid Farzad
 * Introduction to Programming
 * Assignment 2 - Question 1
 *
 * Q1: User input amounts in 2 bank accounts with different interest rates, check when CIBC account >= RBC and output amounts
 * in each account.
 * A3:
 * Input: 4 Double
 * Output: Formatting String + 1 Int and 2 Double
 * */
import java.util.Scanner;

public class Answer1 {
    public static void main(String[] args) {
        final Scanner inputObj = new Scanner(System.in);
        // Get input from the user
        System.out.print("Enter CA$ amount deposited in RBC: ");
        double rbcAmountDouble = inputObj.nextDouble();
        System.out.print("Enter CA$ amount deposited in CIBC: ");
        double cibcAmountDouble = inputObj.nextDouble();
        System.out.print("Enter the interest rate of RBC: ");
        final double rbcInterestDouble = inputObj.nextDouble();
        System.out.print("Enter the interest rate of CIBC: ");
        final double cibcInterestDouble = inputObj.nextDouble();

        // Recurse interest accumulation until cibcAmountDouble >= rbcAmountDouble
        int numberOfYears = 0;
        while (cibcAmountDouble <= rbcAmountDouble) {
            rbcAmountDouble += rbcAmountDouble * rbcInterestDouble / 100;
            cibcAmountDouble += cibcAmountDouble * cibcInterestDouble / 100;
            numberOfYears++;
        }

        // Output formatted data
        System.out.printf("                 Analysis Result          %n" +
                "               -------------------          %n"
                + "After %d year(s), the balance in CIBC will be >= to RBC.%n" +
                "After %d year(s), the balance in RBC is CA$ %.2f%n" +
                "After %d year(s), the balance in CIBC is CA$ %.2f",
                numberOfYears, numberOfYears, rbcAmountDouble, numberOfYears, cibcAmountDouble
        );
    }

}
