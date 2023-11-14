package dev.chrisyx511.cs1.romanNumerals;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Character, Integer> romanToNumber = new HashMap<>();
        romanToNumber.put('M', 1000);
        romanToNumber.put('D', 500);
        romanToNumber.put('C', 100);
        romanToNumber.put('L', 50);
        romanToNumber.put('X', 10);
        romanToNumber.put('V', 5);
        romanToNumber.put('I', 1);

        final Scanner in = new Scanner(System.in);
        System.out.println("Enter roman number: ");
        final String romanNumber = in.nextLine();
        int number = 0;
        for (int i = 0; i < romanNumber.length(); i++) {
            int addedNumber = romanToNumber.get(romanNumber.charAt(i));
            if (i == romanNumber.length() - 1) {
                number += addedNumber;
                continue;
            }
            if (romanNumber.charAt(i) == 'C' && (romanNumber.charAt(i + 1) == 'M' || romanNumber.charAt(i + 1) == 'D')) {
                number -= addedNumber;
                continue;
            }
            if (romanNumber.charAt(i) == 'X' && (romanNumber.charAt(i + 1) == 'C' || romanNumber.charAt(i + 1) == 'L')) {
                number -= addedNumber;
                continue;
            }
            if (romanNumber.charAt(i) == 'I' && (romanNumber.charAt(i + 1) == 'X' || romanNumber.charAt(i + 1) == 'V')) {
                number -= addedNumber;
                continue;
            }
            number += addedNumber;
        }
        System.out.println(number);
    }
}
