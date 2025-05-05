package utils;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
