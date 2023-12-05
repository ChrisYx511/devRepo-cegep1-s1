package dev.chrisyx511.cs1.Arrays1;

import java.util.ArrayList;

public class Question5 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 6, 7, 13, 6, 0};
        ArrayList<Integer> perfectNum = new ArrayList<>();
        ArrayList<Integer> primeNum = new ArrayList<>();
        for (int j : arr) {
            if (isPrime(j)) {
                primeNum.add(j);
            }
            if (isPerfect(j)) {
                perfectNum.add(j);
            }
        }
        System.out.println("Prime numbers: " + primeNum);
        System.out.println("Perfect numbers: " + perfectNum);
    }

    static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isPerfect(int num) {
        int sum = 1;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return (sum == num);
    }
}
