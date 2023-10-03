import java.util.Scanner;

public class MultiplicationTables {
    public static void main(String[] args) {
        final Scanner userInput = new Scanner(System.in);
        System.out.print("Enter number:");
        int userInputNumber = userInput.nextInt();
        for (int i = 0; i < 13; i++) {
            System.out.print(userInputNumber + " * " + i + " = ");
            System.out.println(userInputNumber*i);
        }
    }
}
