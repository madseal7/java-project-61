package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class ProgressionGame {

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
        System.out.println("What number is missing in the progression?");

        int correctAnswers = 0;
        while (correctAnswers < 3) {
            int progressionLength = random.nextInt(6) + 5;
            int startValue = random.nextInt(50) + 1;
            int step = random.nextInt(10) + 1;
            int hiddenIndex = random.nextInt(progressionLength);

            int[] progression = new int[progressionLength];
            for (int i = 0; i < progressionLength; i++) {
                progression[i] = startValue + i * step;
            }

            int correctAnswer = progression[hiddenIndex];
            progression[hiddenIndex] = -1;

            StringBuilder question = new StringBuilder();
            for (int num : progression) {
                if (num == -1) {
                    question.append(".. ");
                } else {
                    question.append(num).append(" ");
                }
            }
            System.out.println("Question: " + question.toString().trim());
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
}
