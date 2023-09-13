package dev.chrisyx511.cs1.stringmanipulationx1;

import java.util.Scanner;

public class Exercise12 {
    public static void main(String[] args) {

        String str = "Montreal is one of the beautiful cities in Canada.";
        Scanner input = new Scanner(System.in);
        System.out.print("Enter string 1: ");
        String str1 = input.nextLine();
        str1 = str1.trim().toLowerCase();
        System.out.print("Enter string 2: ");
        String str2 = input.nextLine();
        str2 = str2.trim().toLowerCase();
        System.out.println("String at: " + returnFilter(str2,str1));
    }
    public static String returnFilter(String str, String filter) {
        if (!str.contains(filter)) {
            return "Does not contain filter!";
        }
        return Integer.toString(str.indexOf(filter));
    }
}
