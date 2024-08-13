package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int correctAnswers = 0;
        while (correctAnswers < 3) {
            int number = random.nextInt(100);
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (isEven(number) && answer.equalsIgnoreCase("yes")
                    || !isEven(number) && answer.equalsIgnoreCase("no")) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("'"  + answer + "' is wrong answer ;(. Correct answer was '"
                        + (isEven(number) ? "yes" : "no") + "'.");
                System.out.println("Let's try again, " + userName + "!");
                correctAnswers = 0;
            }
        }

        if (correctAnswers == 3) {
            System.out.println("Congratulations, " + userName + "!");
        }

        scanner.close();
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
