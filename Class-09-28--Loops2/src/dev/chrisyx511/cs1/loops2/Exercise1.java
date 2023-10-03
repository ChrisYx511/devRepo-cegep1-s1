package dev.chrisyx511.cs1.loops2;

import java.util.Scanner;
// Find Exponent
public class Exercise1 {
    public static void main(String[] args) {
        final Scanner userInputObj = new Scanner(System.in);
        System.out.println("Enter base:");
        int base = userInputObj.nextInt();
        System.out.println("Enter exponent:");
        int exponent = userInputObj.nextInt();
        int result = base;

        if (exponent > 0) {
            for (int i = 0; i < exponent - 1; i++) {
                result = result * base;
            }
            System.out.println("Result: " + result);
        } else if (exponent < 0) {
            for (int i = 0; i < -exponent - 1; i++) {
                result = result * base;
            }
            System.out.println("Result (expression): 1 / " + result);
            final double doubleResult = (double) 1 / (result);
            System.out.println("Result (decimal): " + doubleResult);
        } else {
            System.out.println(1);
        }
    }
}
