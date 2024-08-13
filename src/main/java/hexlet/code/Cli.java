package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void getUserName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("May i have your name? ");
        String name = scanner.nextLine();
        System.out.print("Hello, " + name + "!");
    }
}
