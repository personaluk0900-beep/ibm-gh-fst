
import java.util.*;
import java.io.*;

public class RockPaperScissors {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    static class Player {
        String name;
        int wins = 0;
        int losses = 0;
        int ties = 0;

        Player(String name) {
            this.name = name;
        }

        int getScore() {
            return wins;
        }
    }

    static int computerChoice() {
        return random.nextInt(3) + 1;
    }

    static String moveName(int c) {
        switch (c) {
            case 1: return "Rock";
            case 2: return "Paper";
            default: return "Scissors";
        }
    }

    static void saveScore(Player p) {
        try (FileWriter fw = new FileWriter("scores.txt", true)) {
            fw.write("Player: " + p.name +
                    " | Wins: " + p.wins +
                    " | Losses: " + p.losses +
                    " | Ties: " + p.ties + "\n");
        } catch (IOException e) {
            System.out.println("Unable to save score.");
        }
    }

    static void showHistory() {
        File f = new File("scores.txt");
        if (!f.exists()) {
            System.out.println("No previous records found.");
            return;
        }
        System.out.println("\n===== SCORE HISTORY =====");
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            System.out.println("Error reading history.");
        }
    }

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" ROCK PAPER SCISSORS");
        System.out.println("=================================");

        System.out.print("Enter your name: ");
        Player player = new Player(sc.nextLine());

        boolean run = true;

        while (run) {

            System.out.println("\n1. Play");
            System.out.println("2. View History");
            System.out.println("3. Exit");
            System.out.print("Choice: ");

            int menu;

            try {
                menu = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (menu) {

                case 1:

                    System.out.println("\nBest of 3 Match!");

                    int rounds = 0;

                    while (rounds < 3) {

                        int userChoice;

                        while (true) {
                            try {
                                System.out.println("\n1.Rock");
                                System.out.println("2.Paper");
                                System.out.println("3.Scissors");
                                System.out.print("Enter: ");

                                userChoice = Integer.parseInt(sc.nextLine());

                                if (userChoice < 1 || userChoice > 3)
                                    throw new Exception();

                                break;

                            } catch (Exception e) {
                                System.out.println("Enter only 1-3.");
                            }
                        }

                        int comp = computerChoice();

                        System.out.println(player.name + " -> " + moveName(userChoice));
                        System.out.println("Computer -> " + moveName(comp));

                        if (userChoice == comp) {
                            System.out.println("Tie!");
                            player.ties++;
                        } else if ((userChoice == 1 && comp == 3)
                                || (userChoice == 2 && comp == 1)
                                || (userChoice == 3 && comp == 2)) {
                            System.out.println("You Win!");
                            player.wins++;
                        } else {
                            System.out.println("Computer Wins!");
                            player.losses++;
                        }

                        rounds++;

                        System.out.println("----------------------------");
                        System.out.println("Wins   : " + player.wins);
                        System.out.println("Losses : " + player.losses);
                        System.out.println("Ties   : " + player.ties);
                        System.out.println("----------------------------");
                    }

                    saveScore(player);
                    System.out.println("Match Finished!");
                    break;

                case 2:
                    showHistory();
                    break;

                case 3:
                    saveScore(player);
                    System.out.println("Thank you for playing!");
                    run = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}
