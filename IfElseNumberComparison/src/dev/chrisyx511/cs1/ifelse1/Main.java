package dev.chrisyx511.cs1.ifelse1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number: ");
        int no1 = in.nextInt();
        System.out.println("Enter another number: ");
        int no2 = in.nextInt();
        System.out.println("Enter a third number: ");
        int no3 = in.nextInt();

        int pos1 = -1;
        int pos2 = -1;
        int pos3 = -1;

        // Determine position no1
        if (no1 > no2) {
            if (no1 > no3) {
                pos3 = no1;
            } else {
                pos2 = no1;
            }
        } else if (no1 > no3) {
                pos2 = no1;
        } else {
            pos1 = no1;
        }
        // Position of no2
        if (no2 > no1) {
            if (no2 > no3) {
                pos3 = no2;
            } else {
                pos2 = no2;
            }
        } else if (no2 > no3) {
            pos2 = no2;
        } else {
            pos1 = no2;
        }
        // Position of no3
        if (no3 > no1) {
            if (no3 > no2) {
                pos3 = no3;
            } else {
                pos2 = no3;
            }
        } else if (no3 > no2) {
            pos2 = no3;
        } else {
            pos1 = no3;
        }

        System.out.printf("%d, %d, %d %n", pos1, pos2, pos3);
    }
}
