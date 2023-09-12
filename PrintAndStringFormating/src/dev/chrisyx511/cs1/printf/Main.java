package dev.chrisyx511.cs1.printf;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        double amount = 4.50f;
        if (amount > 5) {
            System.out.printf("Hello, %.2f", amount);
        }

        /*
        * %d Decimal
        * %f Float/Double
        * %s String or char
        * %c char
        * %b Boolean
        * */
    }
}