package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class GCDGame {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Find the greatest common divisor of given numbers.");

        int correctAnswers = 0;
        while (correctAnswers < 3) {
            int num1 = random.nextInt(100) + 1;
            int num2 = random.nextInt(100) + 1;

            int correctAnswer = gcd(num1, num2);
            System.out.println("Question: " + num1 + " " + num2);
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();
            scanner.nextLine();

            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                correctAnswers = 0;
            }
        }

        if (correctAnswers == 3) {
            System.out.println("Congratulations, " + userName + "!");
        }

        scanner.close();
    }


    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
