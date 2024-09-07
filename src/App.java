import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static ArrayList<Player> initialize() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();

        System.out.print("Hur många spelare vill spela? ");
        int numberOfPlayers = scanner.nextInt();

        System.out.print("Hur många tärningar ska varje spelare ha? ");
        int numberOfDice = scanner.nextInt();

        System.out.print("Hur många sidor ska tärningarna ha? ");
        int sides = scanner.nextInt();

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Namn på spelare " + (i + 1) + ": ");
            String name = scanner.next();
            Player player = new Player(name);

            for (int j = 0; j < numberOfDice; j++) {
                player.addDie(sides);
            }

            players.add(player);
        }

        return players;
    }

    private static void takeTurn(ArrayList<Player> players) {
        Scanner scanner = new Scanner(System.in);

        for (Player player : players) {
            System.out.print(player.getName() + ", gissa det sammanlagda värdet av dina tärningar: ");
            int guess = scanner.nextInt();

            player.rollDice();

            int totalValue = player.getDieValue();
            System.out.println(player.getName() + " rullade " + totalValue);

            if (guess == totalValue) {
                player.increaseScore();
                System.out.println("Rätt gissning! Poäng till " + player.getName());
            } else {
                System.out.println("Fel gissning.");
            }
        }
    }

    private static ArrayList<Player> getWinners(ArrayList<Player> players) {
        ArrayList<Player> winners = new ArrayList<>();
        int highestScore = 0;

        for (Player player : players) {
            if (player.getScore() > highestScore) {
                highestScore = player.getScore();
            }
        }

        for (Player player : players) {
            if (player.getScore() == highestScore) {
                winners.add(player);
            }
        }

        return winners;
    }

    public static void main(String[] args) {
        ArrayList<Player> players = initialize(); // Starta spelet och skapa spelare

        for (int i = 1; i <= 5; i++) {
            System.out.println("\nRunda " + i);
            takeTurn(players);
        }

        ArrayList<Player> winners = getWinners(players);

        System.out.println("\nSpelet är över! Vinnare:");
        for (Player winner : winners) {
            System.out.println(winner.getName() + " med " + winner.getScore() + " poäng.");
        }
    }
}
