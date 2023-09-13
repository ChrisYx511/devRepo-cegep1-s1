package dev.chrisyx511.cs1.stringmanipulationx1;

import java.util.Scanner;

public class CelsiusToFahrenheitAndKelvin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter temperature in celsius: ");
        double tempInCelsius = input.nextDouble();
        System.out.println("Fahrenheit: " + toFahrenheit(tempInCelsius) + " Kelvin: " + toKelvin(tempInCelsius));
    }
    public static double toFahrenheit(double celsius) {
        return celsius * 9/5 + 32;
    }
    public static double toKelvin(double celsius) {
        return celsius + 273;
    }
}
