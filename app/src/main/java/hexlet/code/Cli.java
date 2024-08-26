package hexlet.code;
import java.util.Scanner;

public class Cli {
    public static void greetUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May i have your name? ");
        String name = scanner.nextLine();
        System.out.print("Hello, " + name + "!");
    }
}
