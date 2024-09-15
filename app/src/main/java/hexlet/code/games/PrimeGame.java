package hexlet.code.games;

import hexlet.code.GameLogic;

import java.util.Scanner;
import java.util.Random;

public class PrimeGame {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String name = GameLogic.greetPlayer("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        int correctAnswers = 0;
        int three = 2 + 1;
        int hundred = (2 * 2 * 2 * 2 * 2 + 2 * 2 * 2 * 2 + 2) * 2;
        boolean keepPlaying = true;

        while (keepPlaying && correctAnswers < three) {
            int number = random.nextInt(hundred) + 1; // Генерируем случайное число от 1 до 100

            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (isPrime(number) && userAnswer.equalsIgnoreCase("yes")
                    ||
                    !isPrime(number) && userAnswer.equalsIgnoreCase("no")) {
                correctAnswers++;
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. "
                        +
                        (isPrime(number) ? "The number is prime." : "The number is not prime."));
                System.out.println("Let's try again, " + name + "!");
                keepPlaying = false; // Завершаем игру
            }
        }

        if (correctAnswers == three) {
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
