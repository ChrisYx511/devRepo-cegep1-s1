package dev.chrisyx511.cs1.loops2;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        final Scanner userInputObj = new Scanner(System.in);
        System.out.println("Enter number:");
        int userInputInt = userInputObj.nextInt();
        boolean isPrimeBool = true;
        for (int i = 2; i < userInputInt / 2; i++ ) {
            if (userInputInt % i == 0) {
                isPrimeBool = false;
                break;
            }
        }
        if (isPrimeBool) {
            System.out.println("Is Prime!");
        } else {
            System.out.println("Is not prime!");
        }
        userInputObj.close();
    }
}
