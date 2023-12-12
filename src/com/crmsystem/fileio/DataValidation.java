package com.crmsystem.fileio;

import java.util.Scanner;

public class DataValidation {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt(String prompt) {
        int input = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.println(prompt);
                input = Integer.parseInt(scanner.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return input;
    }

    public static String getString(String prompt) {
        String input = "";

        while (input.isEmpty() || containsDigits(input)) {
            System.out.println(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty() || containsDigits(input)) {
                System.out.println("Invalid input. Please enter a non-empty string or without numbers.");
            }
        }
        return input;
    }

    private static boolean containsDigits(String input) {
        return input.matches(".*\\d.*");
    }

    public static double getDouble(String prompt) {
        double input = 0.0;
        boolean isValid = false;

        while (!isValid) {
            System.out.println(prompt);
            String inputString = scanner.nextLine().trim();
            try {
                input = Double.parseDouble(inputString);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return input;
    }
}


