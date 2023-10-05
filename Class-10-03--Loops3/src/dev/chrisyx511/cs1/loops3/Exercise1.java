package dev.chrisyx511.cs1.loops3;

import java.util.Scanner;
// Wrong
public class Exercise1 {
    public static void main(String[] args) {
        final Scanner userInputObj = new Scanner(System.in);
        final int userNumberInt = userInputObj.nextInt();
        int userNumberRemainingInt = userNumberInt;
        int consolidatedNewValue = 0;
        int numberIndex = 0;
        while (userNumberRemainingInt > 0) {
            int separatedDigit = userNumberRemainingInt % 10;
            userNumberRemainingInt = userNumberRemainingInt / 10;
            int newPower = 1;
            for (int i = 0; i < numberIndex; i++) {
                newPower = newPower * 10;
            }
            newPower = separatedDigit * newPower;
            consolidatedNewValue += newPower;
            numberIndex++;

        }
        System.out.println(consolidatedNewValue);
    }


}
