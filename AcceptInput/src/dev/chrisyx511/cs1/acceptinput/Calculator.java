package dev.chrisyx511.cs1.acceptinput;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator {

    final static DecimalFormat decimalFormat = new DecimalFormat("0.######");
    public static void calculate(float val1, float val2) {
        String val1String = decimalFormat.format(val1);
        String val2String = decimalFormat.format(val2);
        System.out.println(val1String + "+" + val2String + " = " + decimalFormat.format((val1 + val2)) );
        System.out.println(val1String + "-" + val2String + " = " + decimalFormat.format((val1 - val2)) );
        System.out.println(val1String + "*" + val2String + " = " + decimalFormat.format((val1 * val2)) );
        System.out.println(val1String + "/" + val2String + " = " + decimalFormat.format((val1 / val2)) );
    }
    public static void main(String[] args) {
        Scanner consoleInput = new Scanner(System.in);
        System.out.print("Enter first number: ");
        float value1 = consoleInput.nextInt();
        System.out.println(" ");
        System.out.print("Enter second number: ");
        float value2 = consoleInput.nextInt();
        System.out.println(" ");
        System.out.println("The answer is: ");
        Calculator.calculate(value1,value2);

    }
}
