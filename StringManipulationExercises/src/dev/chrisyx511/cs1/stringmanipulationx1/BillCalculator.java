package dev.chrisyx511.cs1.stringmanipulationx1;

import java.util.Scanner;

public class BillCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter subtotal: ");
        double subtotal = input.nextDouble();
        System.out.println(
                "Your bill\n" +
                "_____________________\n" +
                "Subtotal: $" + subtotal + "\n" +
                "GST 5%: $" + calculateGST(subtotal) + "\n" +
                "QST 9.975%: $" + calculateQST(subtotal) + "\n" +
                "Total: $" + (subtotal + calculateGST(subtotal) + calculateQST(subtotal)) + "\n"
        );

    }
    public static double calculateGST(double subtotal) {
        return subtotal * 0.05;
    }
    public static double calculateQST(double subtotal) {
        return subtotal * 0.09975;
    }
}
