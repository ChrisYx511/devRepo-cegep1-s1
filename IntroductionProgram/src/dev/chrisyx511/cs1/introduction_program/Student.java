package dev.chrisyx511.cs1.introduction_program;

public class Student {
    public String name;
    public String familyName;
    public int age;
    public String[] courses;

    Student(String name, String enteredFamilyName, int enteredAge, String[] enteredCourses) {
        this.name = name;
        familyName = enteredFamilyName;
        age = enteredAge;
        courses = enteredCourses;
    }
}
