package hexlet.code;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.\n" +
                "1 - Greet\n" +
                "2 - Even\n" +
                "0 - Exit\n" +
                "Your choice: ");
        int choice = console.nextInt();
        switch (choice){
            case 1:
                Cli.greetUser();
                break;
            case 2:
                EvenGame.start();
                break;
            case 0:
                break;
        }
    }
}
