package dev.chrisyx511.cs1.Arrays1;

public class Question8 {
    // 2D Arrays
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
            int sum = 0;
        for (int j = 0; j < arr[0].length; j++) {
            for (int[] col : arr) {
                sum += col[j];
            }
            System.out.println("Sum of column " + j + ": " + sum);
            sum = 0;
        }

    }
}