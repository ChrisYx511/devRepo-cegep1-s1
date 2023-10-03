import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner userInput = new Scanner(System.in);

        int count = 0;
        while (count < 10) {
            System.out.println(count+1);
            count++;
        }
        int[] userNumbers = new int[10];
        for (int i = 0; i < 10; i++){
            System.out.print("Enter number " + (i+1) + ":");
            userNumbers[i] = userInput.nextInt();

        }
        for (int userNumber : userNumbers) {
            System.out.println(userNumber);
        }

    }
}
