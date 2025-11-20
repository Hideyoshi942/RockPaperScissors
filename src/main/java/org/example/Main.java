package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> choices = List.of("rock", "paper", "scissors");
        Scanner scanner = new Scanner(System.in);

        String playAgain = "y";
        while (playAgain.equalsIgnoreCase("y")) {
            System.out.print("How many times do you want to play: ");
            int numberOfGames;
            try {
                numberOfGames = Integer.parseInt(scanner.nextLine().trim());
                if (numberOfGames <= 0) {
                    System.out.println("Please enter a positive integer.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter an integer.");
                continue;
            }

            int userWins = 0, compWins = 0, draws = 0;

            for (int i = 0; i < numberOfGames; i++) {
                // choose computer move for each round
                String computer = choices.get((int) (Math.random() * choices.size()));

                System.out.print("Enter your choice (rock, paper, scissors): ");
                String userInput = scanner.nextLine().trim().toLowerCase();

                // Validate input
                if (!choices.contains(userInput)) {
                    System.out.println("Invalid choice. Round skipped.");
                    i--; // ask again for this round (optional) OR remove this line to count as played
                    continue;
                }

                System.out.println("Computer: " + computer);
                System.out.println("You: " + userInput);

                if (userInput.equals(computer)) {
                    System.out.println("Draw");
                    draws++;
                } else if (
                        (userInput.equals("rock") && computer.equals("scissors")) ||
                                (userInput.equals("paper") && computer.equals("rock")) ||
                                (userInput.equals("scissors") && computer.equals("paper"))
                ) {
                    System.out.println("You win");
                    userWins++;
                } else {
                    System.out.println("Computer wins");
                    compWins++;
                }
            }

            System.out.println("Game over");
            System.out.printf("Result: You %d - Computer %d - Draws %d%n", userWins, compWins, draws);

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("y")) {
                System.out.println("Goodbye!");
            }
        }

        // scanner.close(); // optional: closing System.in can affect other parts if running in REPL
    }
}
