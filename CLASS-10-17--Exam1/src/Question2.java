
/*
 * (Chris) Xi Yang
 * Mehdi Farshid
 * Introduction to Programming
 * 17 October 2023
 *
 * -- Question 2 --
 * */
import java.util.Scanner;
public class Question2 {
    public static void main(String[] args) {
        final Scanner userInput = new Scanner(System.in);

        System.out.println("Enter a sentence: ");
        final String userSentence = userInput.nextLine();
        System.out.println("Enter a word: ");
        final String userFilterWord = userInput.nextLine();

        System.out.println("Result: ");
        String filteredOutput = userSentence;


        for (int i = 0; i < userSentence.length() - userFilterWord.length() + 1; i++) {
            if (filteredOutput.substring(i, i+userFilterWord.length()).equals(userFilterWord) && (i == 0 || filteredOutput.charAt(i - 1) == ' ')) {
                filteredOutput = filteredOutput.substring(0, i) + returnHiddenString(userFilterWord) + filteredOutput.substring(i + userFilterWord.length() );

            }
            System.out.println(filteredOutput);
        }

    }

    private static String returnHiddenString(String originalString) {
        String hiddenString = "";
        for (int i = 0; i < originalString.length(); i++) {
            hiddenString += "*";
        }
        return hiddenString;
    }

}
