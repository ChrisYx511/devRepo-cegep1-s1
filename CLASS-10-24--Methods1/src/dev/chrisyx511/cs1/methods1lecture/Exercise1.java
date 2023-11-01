package dev.chrisyx511.cs1.methods1lecture;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        final Scanner userInputObj = new Scanner(System.in);
        System.out.println("Enter a number to check if prime: ");
        int userNumber = userInputObj.nextInt();

        if (checkIsPrime(userNumber)) {
            System.out.println(userNumber + " is a prime number!");
        } else {
            System.out.println(userNumber + " is not a prime number!");
        }

        
    }


    /** <script>console.log("Hello World")</script>
     * Check any positive integer checkNumber to see if it is prime
     * @param checkNumber number to check whether it is prime or not
     * @return <code>true</code> if prime, <code>false</code> if not prime
     */
    private static boolean checkIsPrime(int checkNumber) {
        for (int i = 2; i <= checkNumber / 2; i++) {
            if (checkNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}
