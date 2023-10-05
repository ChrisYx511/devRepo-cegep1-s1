package dev.chrisyx511.cs1.loops3;

import java.util.Scanner;
// 2023-10-05 ONWARDS
public class Exercise2 {
    public static void main(String[] args) {
        System.out.println("Enter number n , 1 + ... + 1/n : ");
        final Scanner userInputObj = new Scanner(System.in);
        final int userNumberInt = userInputObj.nextInt();
        double result = 1;
        for (int i = 2; i <= userNumberInt; i++) {
            result += 1.0/i;
            System.out.println(" + 1/" + i + " = " + result);
        }
        System.out.println("Result: " + result);
    }
}
