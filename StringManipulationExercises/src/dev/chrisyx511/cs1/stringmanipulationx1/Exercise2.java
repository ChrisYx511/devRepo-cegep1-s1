package dev.chrisyx511.cs1.stringmanipulationx1;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        String str = "Montreal is one of the beautiful cities in Canada.";
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string to filter position: ");
        String filter = input.nextLine();
        System.out.println("String at: " + returnFilter(str,filter));
    }
    public static String returnFilter(String str, String filter) {
        if (!str.contains(filter)) {
            return "Does not contain filter!";
        }
        return Integer.toString(str.indexOf(filter));
    }
}
