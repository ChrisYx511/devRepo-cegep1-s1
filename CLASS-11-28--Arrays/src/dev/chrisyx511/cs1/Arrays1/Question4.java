package dev.chrisyx511.cs1.Arrays1;

import java.util.Arrays;

public class Question4 {
    public static void main(String[] args) {
        String[] arr = new String[]{"A", "BB", "C", "D", "E"};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    continue;
                }
                final String temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
            System.out.println(Arrays.toString(arr));

        }
        System.out.println(Arrays.toString(arr));
    }
}
