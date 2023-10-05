package dev.chrisyx511.cs1.loops3;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        final Scanner userInputObj = new Scanner(System.in);

        System.out.println("Begin Range: ");
        final int userNumberInt1 = userInputObj.nextInt();
        System.out.println("End Range: ");
        final int userNumberInt2 = userInputObj.nextInt();

        for (int i = userNumberInt1; i < userNumberInt2; i++) {
            if (checkIfPerfect(i)) {
                System.out.println(i + " is Perfect");
            }
        }

        userInputObj.close();
    }
    public static boolean checkIfPerfect(int number) {
         /*
        1. Grab a list of Divisors
        2. Check if the Divisors add up to the number entered
         */
        int sumOfDivisors = 1;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                sumOfDivisors += i;

            }
        }

        return (sumOfDivisors == number);
    }
}