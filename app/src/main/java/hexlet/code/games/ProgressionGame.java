package hexlet.code.games;

import java.util.Scanner;
import java.util.Random;

public class ProgressionGame {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "!");
        System.out.println("What number is missing in the progression?");

        boolean keepPlaying = true;

        while (keepPlaying) {
            int progressionLength = random.nextInt(6) + 5; // Длина прогрессии от 5 до 10
            int startNumber = random.nextInt(50) + 1; // Начальное число
            int step = random.nextInt(10) + 1; // Шаг прогрессии
            int hiddenIndex = random.nextInt(progressionLength); // Индекс спрятанного числа

            int[] progression = new int[progressionLength];
            for (int i = 0; i < progressionLength; i++) {
                progression[i] = startNumber + i * step;
            }

            // Заменяем спрятанное число на ".."
            progression[hiddenIndex] = -1;

            // Вывод прогрессии
            StringBuilder question = new StringBuilder("Question: ");
            for (int i = 0; i < progressionLength; i++) {
                if (progression[i] == -1) {
                    question.append(".. ");
                } else {
                    question.append(progression[i]).append(" ");
                }
            }
            System.out.println(question.toString().trim());

            // Запрашиваем ответ пользователя
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // Проверяем ответ
            int correctAnswer = startNumber + hiddenIndex * step;
            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                keepPlaying = false; // Завершаем игру
            }
        }
    }
}