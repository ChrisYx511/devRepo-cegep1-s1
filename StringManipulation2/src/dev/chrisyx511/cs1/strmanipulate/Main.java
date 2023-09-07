package dev.chrisyx511.cs1.strmanipulate;

public class Main {
    public static void main(String[] args) {
        System.out.println('\u0063');
        System.out.println('\u0043');

        int n = 20;
        int y = 56;
        double ans = n / (double) y;
        System.out.println(ans);
        // If one of them double, result double

        /*
        * # Best Practices for Coding
        *
        *
        *
        * */
        enum Color {
            RED,
            GREEN,
            BLUE
        }
        Color c1 = Color.RED;
        System.out.println(c1);
    }
}
