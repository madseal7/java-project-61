package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;
public class GCDGame {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int three = 2 + 1;
        int hundred = (2 * 2 * 2 * 2 * 2 + 2 * 2 * 2 * 2 + 2) * 2;

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "!");
        System.out.println("Find the greatest common divisor of given numbers.");

        int correctAnswers = 0;
        boolean keepPlaying = true; // Флаг для продолжения игры

        while (keepPlaying && correctAnswers < three) {
            int num1 = random.nextInt(hundred) + 1;
            int num2 = random.nextInt(hundred) + 1;
            int correctAnswer = gcd(num1, num2);

            System.out.println("Question: " + num1 + " " + num2);
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (userAnswer == correctAnswer) {
                correctAnswers++;
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                keepPlaying = false; // Завершаем игру
            }
        }

        if (correctAnswers == three) {
            System.out.println("Congratulations, " + name + "!");
        }
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
