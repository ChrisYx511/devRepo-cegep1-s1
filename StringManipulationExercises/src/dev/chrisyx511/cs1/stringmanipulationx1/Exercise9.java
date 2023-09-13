package dev.chrisyx511.cs1.stringmanipulationx1;

public class Exercise9 {
    public static void main(String[] args) {
        String str = "This is a really long string!";
        int middleIndex = (str.length() / 2);
        System.out.println("Part 1: " + str.substring(0, middleIndex) + " | Part 2: " + str.substring(middleIndex));
    }
}
