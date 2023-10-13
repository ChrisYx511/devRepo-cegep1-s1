package dev.chrisyx511.cs1.Assignment2;
/*
 * (Chris) Xi Yang
 * Mehdi Farshid Farzad
 * Introduction to Programming
 * Assignment 2 - Question 3
 *
 * Q3: Resolve the mathematical expression as described in the assignment handout
 * A3:
 * Input: 1 Integer
 * Output: 1 Double
 * */
import java.util.Scanner;

public class Answer3 {
    public static void main(String[] args) {
        // Get user input
        final Scanner inputObj = new Scanner(System.in);
        System.out.print("Enter the n: ");
        final int userInputValueInt = inputObj.nextInt();
        // Declare final result variable
        double finalValueDouble = 0;
        // Declare flag to determine sign
        boolean signIsPlusBool = false;
        // In increments of 2, execute the addition or the subtraction depending on signIsPlusBool
        for (int i = 1; i <= userInputValueInt; i += 2) {
            // Check for i == 1 because first operation is always positive
            if (signIsPlusBool || i == 1) {
                finalValueDouble += (double) getPositiveExponent(i,(i+1)) / getFactorial(i+1);
                //System.out.println(finalValueDouble);
            } else {
                finalValueDouble -= (double) getPositiveExponent(i,(i+1)) / getFactorial(i+1);
                //System.out.println(finalValueDouble);
            }
            signIsPlusBool = !signIsPlusBool;

        }
        // Output result
        System.out.println("Result = " + finalValueDouble);

    }

    /**
     *     Method to return the factorial of the first argument, positive integer originalValue.
     * @param originalValue The value to which the factorial operation is applied
     * @return Result of the factorial operation (originalValue!)
      */
    private static long getFactorial(int originalValue) {
        long outputValue = originalValue;
        for (int i = 2; i < originalValue; i++ ) {
            outputValue = outputValue * i;
        }

        return outputValue;
    }

    /**
     * Method to return the value of the first argument, as long as it is a positive integer, raised to the power of the second argument,
     * also a positive integer.
     * @param base The base used to find the exponential value
     * @param exponent The exponent to which the result is calculated
     * @return Result of the exponentiation operation (base <sup>exponent</sup>)
     */
    private static long getPositiveExponent(int base, int exponent) {
        long result = base;
        for (int i = 2; i <= exponent; i++) {
            result = result * base;
        }
        if (exponent == 0) {
            result = 1;
        }
        return result;

    }
}
