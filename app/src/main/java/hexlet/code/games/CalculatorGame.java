package hexlet.code.games;

import java.util.Scanner;
import java.util.Random;

public class CalculatorGame {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "!");
        System.out.println("What is the result of the expression?");

        int correctAnswers = 0;
        boolean keepPlaying = true;

        while (keepPlaying && correctAnswers < 3) {
            int num1 = random.nextInt(100) + 1;
            int num2 = random.nextInt(100) + 1;
            char operator = getOperator(random);

            int correctAnswer = calculate(num1, num2, operator);
            System.out.println("Question: " + num1 + " " + operator + " " + num2);
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();
            scanner.nextLine();

            if (userAnswer == correctAnswer) {
                correctAnswers++;
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                keepPlaying = false;
            }
        }

        if (correctAnswers == 3) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    private static char getOperator(Random random) {
        int operatorIndex = random.nextInt(3);
        switch (operatorIndex) {
            case 0: return '+';
            case 1: return '-';
            case 2: return '*';
            default: return '+';
        }
    }

    private static int calculate(int num1, int num2, char operator) {
        switch (operator) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            default: return 0;
        }
    }
}