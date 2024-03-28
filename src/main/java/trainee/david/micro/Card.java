package trainee.david.micro;

public abstract class Card {

    protected final int cardId;
    protected String name;
    protected double credit;

    public Card(int cardId, String name, double credit) {
        this.cardId = cardId;
        this.name = name;
        this.credit = credit;
    }

    public abstract boolean pay(int amount);

    @Override
    public String toString() {
        return "[%d]\t%s\t€%.2f".formatted(cardId, name, credit);
    }
}
