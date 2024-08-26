package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class CalculatorGame {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
        System.out.println("What is the result of the expression?");

        int correctAnswers = 0;
        while (correctAnswers < 3) {
            int num1 = random.nextInt(100);
            int num2 = random.nextInt(100);
            char operation = getOperation(random);

            int correctAnswer = calculate(num1, num2, operation);
            System.out.println("Question: " + num1 + " " + operation + " " + num2);
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

    private static char getOperation(Random random) {
        char[] operations = {'+', '-', '*'};
        return operations[random.nextInt(operations.length)];
    }

    private static int calculate(int num1, int num2, char operation) {
        switch (operation) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                return 0;
        }
    }
}
