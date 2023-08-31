package dev.chrisyx511.cs1.acceptinput;

import java.util.Scanner;

public class BadCalculator {

    public static void main(String[] args) {
        Scanner consoleInput = new Scanner(System.in);
        System.out.print("Enter first number: ");
        float value1 = consoleInput.nextInt();
        System.out.println(" ");
        System.out.print("Enter second number: ");
        float value2 = consoleInput.nextInt() + (float) Math.floor(Math.random() * 5);
        System.out.println(" ");
        System.out.println("The answer is: ");
        Calculator.calculate(value1,value2);
    }
}
