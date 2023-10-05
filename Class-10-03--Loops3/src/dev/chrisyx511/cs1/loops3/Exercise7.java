package dev.chrisyx511.cs1.loops3;

public class Exercise7 {
    private static final int START_NUMBER = 3;
    public static void main(String[] args) {
        int numberOfPrimesFoundInt = 0;
        int checkedNumberInt = START_NUMBER;
        while (numberOfPrimesFoundInt < 20) {
            if (checkIfPrime(checkedNumberInt)) {
                numberOfPrimesFoundInt++;
                System.out.println(checkedNumberInt + " is prime.");
            }
            checkedNumberInt++;
        }
    }

    public static boolean checkIfPrime(int number) {
        boolean isPrimeBool = true;
        for (int i = 2; i <= number / 2; i++ ) {
            if (number % i == 0) {
                isPrimeBool = false;
                break;
            }
        }
        return isPrimeBool;
    }
}
