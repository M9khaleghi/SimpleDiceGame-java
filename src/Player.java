import java.util.ArrayList;

public class Player {
    private String name;
    private int score;
    private ArrayList<Die> dice;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.dice = new ArrayList<>(); 
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        this.score++;
    }

    public void addDie(int sides) {
        this.dice.add(new Die(sides));
    }

    public void rollDice() {
        for (Die die : dice) {
            die.roll();
        }
    }

    public int getDieValue() {
        int sum = 0;
        for (Die die : dice) {
            sum += die.getValue();
        }
        return sum;
    }
}
