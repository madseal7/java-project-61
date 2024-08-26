package hexlet.code.games;

import java.util.Scanner;
import java.util.Random;

public class PrimeGame {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        int correctAnswers = 0;
        boolean keepPlaying = true;

        while (keepPlaying && correctAnswers < 3) {
            int number = random.nextInt(100) + 1; // Генерируем случайное число от 1 до 100

            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (isPrime(number) && userAnswer.equalsIgnoreCase("yes") ||
                    !isPrime(number) && userAnswer.equalsIgnoreCase("no")) {
                correctAnswers++;
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. " +
                        (isPrime(number) ? "The number is prime." : "The number is not prime."));
                System.out.println("Let's try again, " + name + "!");
                keepPlaying = false; // Завершаем игру
            }
        }

        if (correctAnswers == 3) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    // Проверка на простоту числа
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
