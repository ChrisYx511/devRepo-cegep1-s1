package dev.chrisyx511.cs1.Arrays1;

import java.util.Arrays;

public class Question3 {
    // Bubble Sort
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 6, 7, 13, 6, 0};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    final int k = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = k;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
