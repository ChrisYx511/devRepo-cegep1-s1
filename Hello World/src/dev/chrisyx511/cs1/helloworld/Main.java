package dev.chrisyx511.cs1.helloworld;

import dev.chrisyx511.cs1.helloworld.test2.*;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!");
        char[] test2 = "asd".toCharArray();
        System.out.println(test2);
        int[] arrayOfNumbers = {3,4,5};
        Scanner input1 = new Scanner(System.in);
        String rec1 = input1.nextLine();
        System.out.println(rec1);
        int addResult = Test2.addition(1,2);
        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Ctrl+D to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Cmd+F8.
            System.out.println("i = " + i);
        }
    }
}