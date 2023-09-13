package dev.chrisyx511.cs1.stringmanipulationx1;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        System.out.print("Enter your full name: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String[] nameSplit = name.split(" ");
        StringBuilder finalOutput = new StringBuilder();
        for (int i = 0; i < (nameSplit.length); i++) {
            if (i == nameSplit.length - 1) {
                finalOutput.append(nameSplit[i]);
            } else {
                finalOutput.append(nameSplit[i].charAt(0)).append(". ");
            }

        }
        System.out.println(finalOutput);
    }



}
