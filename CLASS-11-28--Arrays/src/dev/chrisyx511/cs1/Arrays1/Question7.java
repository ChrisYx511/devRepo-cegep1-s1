package dev.chrisyx511.cs1.Arrays1;

public class Question7 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,1,2,3,2,4,5,3};
        int[] b = new int[]{2,1,1,2,5,1,3,2,4,5};
        int[] filter = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            boolean inFilter = false;
            for (int j = 0; j < filter.length; j++) {
                if (filter[j] != a[i]) {
                    inFilter = false;
                }
                break;
            }
        }
    }
}
