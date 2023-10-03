package dev.chrisyx511.cs1.exercises0921;

import java.util.Scanner;

public class Exercise1 {
    final static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        int side1, side2, side3;

        int angle1, angle2, angle3;

        System.out.print("Side 1: ");
        side1 = userInput.nextInt();
        System.out.print("Side 2: ");
        side2 = userInput.nextInt();
        System.out.print("Side 3: ");
        side3 = userInput.nextInt();
        System.out.print("Angle 1: ");
        angle1 = userInput.nextInt();
        System.out.print("Angle 2: ");
        angle2 = userInput.nextInt();
        System.out.print("Angle 3: ");
        angle3 = userInput.nextInt();

        if ((side1 + side2 > side3) && (side2 + side3 > side1) && (side1 + side3 > side2)) {
            if (angle1 + angle2 + angle3 == 180) {
                System.out.println("This is a triangle!");

            } else {
                System.out.println("Not a triangle");
                System.exit(3);
            }


        } else {
            System.out.println("Not a triangle");
            System.exit(3);
        }

    }

}
