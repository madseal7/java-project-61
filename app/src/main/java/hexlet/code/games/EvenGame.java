package hexlet.code.games;

import java.util.Scanner;

public class EvenGame {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
                int three = 3;
                int hundred = 100;
                System.out.println("Welcome to the Brain Games!");
                System.out.print("May I have your name? ");
                String name = scanner.nextLine();

                System.out.println("Hello, " + name + "!");
                System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

                int correctAnswers = 0;
                boolean keepPlaying = true; // Флаг для продолжения игры

                while (keepPlaying && correctAnswers < three) {
                    int number = (int) (Math.random() * hundred) + 1;
                    System.out.println("Question: " + number);
                    System.out.print("Your answer: ");
                    String answer = scanner.nextLine().toLowerCase();

                    if (isAnswerCorrect(number, answer)) {
                        correctAnswers++;
                        System.out.println("Correct!");
                    } else {
                        System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                                + (number % 2 == 0 ? "yes" : "no") + "'.");
                        System.out.println("Let's try again, " + name + "!");
                        keepPlaying = false; // Завершаем игру
                    }
                }

                if (correctAnswers == three) {
                    System.out.println("Congratulations, " + name + "!");
                }
            }

            private static boolean isAnswerCorrect(int number, String answer) {
                if (number % 2 == 0 && answer.equals("yes") || number % 2 != 0 && answer.equals("no")) {
                    return true;
                }
                return false;
            }
        }
