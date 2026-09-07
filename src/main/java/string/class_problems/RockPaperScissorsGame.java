package string.class_problems;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    // Determines the outcome of a single round
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] validMoves = {"Rock", "Paper", "Scissors"};
        int totalRounds = 5;

        // Arrays to store history for the summary table
        String[] playerMoves = new String[totalRounds];
        String[] computerMoves = new String[totalRounds];
        String[] results = new String[totalRounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("=== Welcome to the College Coding Arcade: Rock-Paper-Scissors ===");
        System.out.printf("You will play %d rounds against the computer.\n\n", totalRounds);

        for (int round = 0; round < totalRounds; round++) {
            System.out.printf("--- Round %d ---\n", round + 1);

            // Accept and validate player input
            String playerMove = "";
            while (true) {
                System.out.print("Enter your move (Rock, Paper, Scissors): ");
                playerMove = scanner.nextLine().trim();

                if (playerMove.equalsIgnoreCase("Rock") ||
                        playerMove.equalsIgnoreCase("Paper") ||
                        playerMove.equalsIgnoreCase("Scissors")) {
                    // Standardize casing
                    playerMove = playerMove.substring(0, 1).toUpperCase() + playerMove.substring(1).toLowerCase();
                    break;
                }
                System.out.println("Invalid input! Please enter 'Rock', 'Paper', or 'Scissors'.");
            }

            // Generate computer move randomly
            String computerMove = validMoves[random.nextInt(validMoves.length)];

            // Evaluate round
            String result = playRound(playerMove, computerMove);

            // Save history
            playerMoves[round] = playerMove;
            computerMoves[round] = computerMove;
            results[round] = result;

            // Update stats
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.printf("Round %d — Player: %s, Computer: %s -> %s\n\n",
                    round + 1, playerMove, computerMove, result);
        }

        // Display summary table
        System.out.println("========================== Summary Table ==========================");
        System.out.printf("%-10s | %-15s | %-15s | %-15s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-------------------------------------------------------------------");
        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("%-10d | %-15s | %-15s | %-15s\n",
                    i + 1, playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("===================================================================");

        // Calculate win percentage
        double winPercentage = ((double) wins / totalRounds) * 100.0;

        // Print final summary
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n",
                wins, losses, draws, winPercentage);

        scanner.close();
    }
}
