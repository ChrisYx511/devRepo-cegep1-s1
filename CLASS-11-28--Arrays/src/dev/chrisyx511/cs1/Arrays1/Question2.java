package dev.chrisyx511.cs1.Arrays1;

public class Question2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 6, 7, 13, 6, 0};
        int max = arr[0], min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Diff: " + (max-min));
    }
}
