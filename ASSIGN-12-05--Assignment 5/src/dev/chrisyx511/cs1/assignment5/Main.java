package dev.chrisyx511.cs1.assignment5;

/*
    (Chris) Xi Yang
    Mehdi Farshid Farzad
    Introduction to Programming
    18 November 2023

    -- Assignment 5 --
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        int[] intArr = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter number in position " + (i+1) + " : ");
            intArr[i] = in.nextInt();
            in.nextLine();
        }
        System.out.println("Initial values inside the array: " + Arrays.toString(intArr));
        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] >= 0 || i == 0 || intArr[i - 1] < 0) {
                continue;
            }
            int j = i;
            int temp;
            while (j > 0 && intArr[j-1] >= 0) {
                temp = intArr[j-1];
                intArr[j-1] = intArr[j];
                intArr[j] = temp;
                j--;
            }
        }
        System.out.println("Array values after their shifting: " + Arrays.toString(intArr));
    }
}
