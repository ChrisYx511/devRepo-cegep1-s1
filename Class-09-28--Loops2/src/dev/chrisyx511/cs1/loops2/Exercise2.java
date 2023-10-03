package dev.chrisyx511.cs1.loops2;

import java.util.Scanner;

//Find Factorial
public class Exercise2 {
    public static void main(String[] args) {
        final Scanner userInputObj = new Scanner(System.in);
        System.out.println("Enter base:");
        int base = userInputObj.nextInt();

        if (base < 0) {
            throw new Error("MathUndefinedError: A factorial of a negative number is not well-defined.");
        }
        if (base == 0) {
            System.out.println("Result: " + 1 );
        } else {
            long result = 1;
             while (base >= 1) {
                result = result * (base);
                base--;
            }
            System.out.println("Result: " + result);
        }


    }
}
