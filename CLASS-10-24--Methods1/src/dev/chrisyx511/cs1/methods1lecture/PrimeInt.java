package dev.chrisyx511.cs1.methods1lecture;

public class PrimeInt {
    public boolean isPrime;
    public int value;
    PrimeInt(int number){
        isPrime = checkIsPrime(number);
        value = number;
    }
    public static boolean checkIsPrime(int checkNumber){
            for (int i = 2; i <= checkNumber / 2; i++) {
                if (checkNumber % i == 0) {
                    return false;
                }
            }
        return true;
    }
}
