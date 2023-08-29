package dev.chrisyx511.cs1.introduction_program;

public class Main {

    public static String coursesStringGen(String[] arrayOfCourses) {
        if (arrayOfCourses.length == 1) {
            return arrayOfCourses[0];
        }
        StringBuilder courseString = new StringBuilder();
        for (int i = 0; i < arrayOfCourses.length; i++) {
            if (i == arrayOfCourses.length - 1) {
                courseString.append("and ").append(arrayOfCourses[i]);
                break;
            }
            courseString.append(arrayOfCourses[i]).append(", ");
        }
        return courseString.toString();
    }
    public static void main(String[] args) {
        Student num2358310 = new Student("Chris","Yang", 17, new String[] {
                "200.C0 Computer Science",
                "Pure and Applied Sciences",
                "Science and Music"
        });
        Integer a = 1;
        System.out.println("My name is " + num2358310.name + ", and my family name is " + num2358310.familyName + ".");
        System.out.println("I am " + num2358310.age + " years old, and I have applied for " + Main.coursesStringGen(num2358310.courses) + ".");

    }
}
