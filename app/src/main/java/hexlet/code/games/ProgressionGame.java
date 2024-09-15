package hexlet.code.games;

import hexlet.code.GameLogic;

import java.util.Scanner;
import java.util.Random;

public class ProgressionGame {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String name = GameLogic.greetPlayer("What number is missing in the progression?");
        int correctAnswers = 0;
        boolean keepPlaying = true;
        int errorNum = 2 + 1;
        int one = 1;
        int five = 2 + 2 + 1;
        int six = 2 + 2 + 2;
        int fifty = 2 * 2 * 2 * 2 * 2 + 2 * 2 * 2 * 2 + 2;

        while (keepPlaying && correctAnswers < errorNum) {
            int progressionLength = random.nextInt(six) + five;
            int startNumber = random.nextInt(fifty) + one;
            int step = random.nextInt(five) + one;
            int hiddenIndex = random.nextInt(progressionLength);

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
                correctAnswers++;
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                keepPlaying = false; // Завершаем игру
            }
        }
        int three = 2 + 1;
        if (correctAnswers == three) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}
