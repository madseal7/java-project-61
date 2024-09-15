package hexlet.code;

import java.util.Scanner;

public class GameLogic {

    public static String greetPlayer(String gameRuleGreeting) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "!");
        System.out.println(gameRuleGreeting);
        return name;
        }
    }

