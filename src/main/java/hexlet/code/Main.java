package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Please enter the game number and press Enter.\n"
                +
                "1 - Greet\n"
                +
                "2 - Even\n"
                +
                "3 - Calc\n"
                +
                "4 - GCD\n"
                +
                "5 - Progression\n"
                +
                "0 - Exit\n"
                +
                "Your choice: ");
        int choice = console.nextInt();
        switch (choice) {
            case 1:
                Cli.greetUser();
                break;
            case 2:
                EvenGame.start();
                break;
            case 3:
                CalculatorGame.start();
                break;
            case 4:
                GCDGame.start();
                break;
            case 5:
                ProgressionGame.start();
                break;
            case 0:
                break;
            default:
                System.out.println("Введите число в диапазоне от 0 до 5");
                break;
        }
    }
}
