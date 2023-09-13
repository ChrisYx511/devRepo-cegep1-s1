package dev.chrisyx511.cs1.stringmanipulationx1;

public class Exercise10 {
    public static void main(String[] args) {
        String str = "This is a really long string!";
        int index1 = (str.length() / 3);
        int index2 = ((str.length() / 3)*2);
        System.out.println("Part 1: " + str.substring(0, index1) + " | Part 2: " + str.substring(index1,index2) + " | Part 3: " + str.substring(index2));
    }
}
