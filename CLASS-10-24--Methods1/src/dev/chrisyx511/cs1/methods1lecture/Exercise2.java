package dev.chrisyx511.cs1.methods1lecture;

public class Exercise2 {

    public static void main(String[] args) {
        for (int i = 3; i <= 100; i++) {
            if (PrimeInt.checkIsPrime(i)) {
                System.out.println(i + " is a prime number!");
            }
        }
    }
}
