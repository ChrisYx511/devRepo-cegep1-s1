package dev.chrisyx511.cs1.Assignment2;
/*
 * (Chris) Xi Yang
 * Mehdi Farshid Farzad
 * Introduction to Programming
 * Assignment 2 - Question 1
 *
 * Q1: User input amounts in 2 bank accounts with different interest rates, give the total amount after
 * 3 years.
 * A3:
 * Input: 4 Double
 * Output: 3 String and 2 Double
 * */
// QUESTION: >=? or >?
import java.util.Scanner;

public class Answer1 {
    private final static int NUMBER_OF_YEARS_DEPOSITED = 3;
    public static void main(String[] args) {
        final Scanner inputObj = new Scanner(System.in);

        System.out.print("Enter CA$ amount deposited in RBC: ");
        final double rbcAmountDouble = inputObj.nextDouble();
        System.out.print("Enter CA$ amount deposited in CIBC: ");
        final double cibcAmountDouble = inputObj.nextDouble();
        System.out.print("Enter the interest rate of RBC: ");
        final double rbcInterestDouble = inputObj.nextDouble();
        System.out.print("Enter the interest rate of CIBC: ");
        final double cibcInterestDouble = inputObj.nextDouble();

        final double rbcFinalAmountDouble = getAmountWithInterest(rbcAmountDouble, rbcInterestDouble);
        final double cibcFinalAmountDouble = getAmountWithInterest(cibcAmountDouble, cibcInterestDouble);
        String cibcCompareSignStr;
        if (cibcFinalAmountDouble >= rbcFinalAmountDouble) {
            cibcCompareSignStr = ">=";
        } else {
            cibcCompareSignStr = "<=";
        }

        System.out.printf("                 Analysis Result          %n" +
                "               -------------------          %n"
                + "After 3 year(s), the balance in CIBC will be %s to RBC.%n" +
                "After 3 year(s), the balance in RBC is CA$ %.2f%n" +
                "After 3 year(s), the balance in CIBC is CA$ %.2f",
                cibcCompareSignStr, rbcFinalAmountDouble, cibcFinalAmountDouble
        );
        inputObj.close();
    }

    private static double getAmountWithInterest(double baseAmount, double interestRatePercent) {
        double finalAmount = baseAmount;
        int yearCounter = Answer1.NUMBER_OF_YEARS_DEPOSITED;
        while (yearCounter > 0) {
            finalAmount = finalAmount + finalAmount * (interestRatePercent/100);
            yearCounter--;
        }
        return finalAmount;
    }
}
