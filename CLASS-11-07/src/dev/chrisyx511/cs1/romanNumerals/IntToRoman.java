package dev.chrisyx511.cs1.romanNumerals;

import java.util.HashMap;
import java.util.Scanner;

public class IntToRoman {

    public static void main(String[] args) {
//        HashMap<Integer, String> intToRoman = new HashMap<>();
//        intToRoman.put(1000, "M");
//        intToRoman.put(900, "CM");
//        intToRoman.put(500, "D");
//        intToRoman.put(400, "CD");
//        intToRoman.put(100, "C");
//        intToRoman.put(90, "XC");
//        intToRoman.put(50, "L");
//        intToRoman.put(40, "XL");
//        intToRoman.put(10, "X");
//        intToRoman.put(9, "IX");
//        intToRoman.put(5, "V");
//        intToRoman.put(4, "IV");
//        intToRoman.put(1, "I");
//
//        int num = 10;
//        int position = 1;
//        StringBuilder value = new StringBuilder();
//        while (num > 0) {
//            int retainedDigit = num % 10;
//            int retainedValue = num % 10 * position;
//            if (retainedValue == 0) {
//                num = num / 10;
//                position = position * 10;
//                continue;
//            }
//            if (intToRoman.containsKey(retainedValue)) {
//                value.insert(0, intToRoman.get(retainedValue));
//            } else if (retainedDigit > 5) {
//                value.insert(0, intToRoman.get((retainedValue - 5 * position) / (retainedDigit - 5)).repeat(retainedDigit - 5));
//                value.insert(0, intToRoman.get(5 * position));
//            } else {
//                value.insert(0, intToRoman.get(retainedValue / retainedDigit).repeat(retainedDigit));
//            }
//            num = num / 10;
//            position = position * 10;
//
//        }
        System.out.println("Enter integer: ");
        final Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        in.nextLine();
        System.out.println(betterIntToRoman(number));
    }

    public static String betterIntToRoman(int number) {
        String[] units = new String[] {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = new String[] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = new String[] {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = new String[] {"", "M", "MM", "MMM"};

        return thousands[number / 1000] + hundreds[number % 1000 / 100] + tens[number % 1000 % 100 / 10] + units[number % 1000 % 100 % 10];
    }
}
