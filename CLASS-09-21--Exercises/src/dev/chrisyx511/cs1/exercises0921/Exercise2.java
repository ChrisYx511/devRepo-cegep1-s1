package dev.chrisyx511.cs1.exercises0921;

import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {

        final Scanner userInput = new Scanner(System.in);
        System.out.print("Student Number: ");
        int studentNumber = userInput.nextInt();
        Student currentStudent = new Student();

        System.out.print("Physics Grade: ");
        int physicsGrade = userInput.nextInt();
        System.out.print("Chemistry Grade: ");
        int chemGrade = userInput.nextInt();
        System.out.print("Biology Grade: ");
        int bioGrade = userInput.nextInt();
        System.out.print("Math Grade: ");
        int mathGrade = userInput.nextInt();
        System.out.print("Computer Science Grade: ");
        int compSciGrade = userInput.nextInt();

        int averageGrade = (physicsGrade+chemGrade+bioGrade+mathGrade+compSciGrade) / 5;
        int gradeInNumbers = averageGrade/10;
        String result = switch(gradeInNumbers) {
            case 10, 9:
                yield "A";
            case 8:
                yield "B";
            case 7:
                yield "C";
            case 6:
                yield "D";
            case 5, 4:
                yield "E";
            default:
                yield "F";

        };
        System.out.println(result);
    }
}

class Student {
    public int physicsGrade, chemGrade, bioGrade, mathGrade, compSciGrade;
    public int id;
}