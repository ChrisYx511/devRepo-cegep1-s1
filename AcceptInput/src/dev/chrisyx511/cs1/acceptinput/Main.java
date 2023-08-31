package dev.chrisyx511.cs1.acceptinput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person user = new Person();
        System.out.print("Input name: ");
        Scanner input = new Scanner(System.in);
        user.firstName = input.nextLine();
        System.out.print("Input last name: ");
        user.lastName = input.nextLine();

        System.out.println("Hello, " + user.returnFullName().toLowerCase() + "!");
        System.out.println(user.firstName.equalsIgnoreCase(user.lastName));

    }
}
