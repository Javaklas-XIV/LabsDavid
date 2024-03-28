package trainee.david.other.H10;

public class Android extends Human implements Chargeable{

    private int level;

    public Android(){
        level = 0;
    }

    @Override
    public String greet() {
        return "I'm only half human, but human still... My energy level is " + level + "%";
    }

    @Override
    public int charge(int amount) {
        int newLevel = level + amount;
        if (newLevel <= 100) level = newLevel;
        return level;
    }
}
