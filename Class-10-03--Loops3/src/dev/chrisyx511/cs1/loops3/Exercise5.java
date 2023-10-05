package dev.chrisyx511.cs1.loops3;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        /*
        1. Grab a list of Divisors
        2. Check if the Divisors add up to the number entered
         */
        System.out.println("Enter number to check if it is a perfect number: ");
        final Scanner userInputObj = new Scanner(System.in);
        final int userNumberInt = userInputObj.nextInt();
        int sumOfDivisors = 1;
        for (int i = 2; i < userNumberInt; i++) {
            if (userNumberInt % i == 0) {
                sumOfDivisors += i;

            }
        }


        System.out.println((sumOfDivisors == userNumberInt) ? "Perfect Number!" : "Not a Perfect Number!");
        userInputObj.close();
    }

}
