import java.util.Random;

public class Die {
    private int value;
    private int sides;
    private static Random random = new Random(); 

    public Die(int sides) {
        this.sides = sides;
        roll(); 
    }

    public void roll() {
        this.value = random.nextInt(sides) + 1; 
    }

    public int getValue() {
        return value;
    }

    public int getSides() {
        return sides;
    }
}
