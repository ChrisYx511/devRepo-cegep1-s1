package dev.chrisyx511.cs1.Arrays1;

import java.util.Arrays;

public class Question7 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 1, 2, 3, 2, 4, 5, 3};
        final int[] b = new int[]{2, 1, 1, 2, 5, 1, 3, 2, 4, 5};
        bubbleSort(a);
        int temp = a[a.length - 1];
        for (int k : a) {
            if (temp == k) {
                continue;
            }
            for (int j = 0; j < b.length; j++) {
                if (k == b[j]) {
                    System.out.println("Integer " + k + " is also at position " + (j + 1) + " in second array.");
                }
            }
            temp = k;
        }

    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    final int k = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = k;
                }
                System.out.println(Arrays.toString(arr));
            }
        }
    }

}
