package test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestZonedDateTime {

    public static void main(String[] args) {
        // Define the expected format. The "VV" pattern for the time zone is a best practice.
        // Example input: 2024-09-26T10:30:00 Europe/Paris
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss VV");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a date and time (e.g., 2024-09-26T10:30:00 Europe/Paris):");

        try {
            // 1. Read the entire line of input as a String
            String userInput = scanner.nextLine();

            // 2. Parse the input string into a ZonedDateTime object
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(userInput, formatter);

            System.out.println("Successfully read ZonedDateTime: " + zonedDateTime);

        } catch (DateTimeParseException e) {
            System.err.println("Error: The date and time format was invalid. Please try again.");
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input.");
        } finally {
            scanner.close();
        }
    }
}

