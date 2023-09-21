package dev.chrisyx511.cs1.assign1;

/*
 * (Chris) Xi Yang
 * Mehdi Farshid Farzad
 * Introduction to Programming
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
