import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a number to check if it's a palindrome: ");
        final int userInputNumber = in.nextInt();

        if (userInputNumber == reverseNumber(userInputNumber)) {
            System.out.println(userInputNumber + " is a palindrome!");

        } else {
            System.out.println(userInputNumber + "is NOT a palindrome!");
        }
    }

    private static int reverseNumber(int originalNumber) {
        int num = originalNumber;
        int outputNumber = 0;
        while (num > 0) {
            int seperatedDigit = num % 10;
            outputNumber = outputNumber * 10 + seperatedDigit;
            num /= 10;
        }
        return outputNumber;
    }
}
