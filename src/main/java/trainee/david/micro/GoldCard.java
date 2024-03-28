package trainee.david.micro;

public class GoldCard extends Card{

    private int discount;

    public GoldCard(int cardId, String name, double credit) {
        super(cardId, name, credit);
    }

    public GoldCard(int cardId, String name, double credit, int discount) throws ArgumentOutOfRangeException {
        this(cardId, name, credit);
        setDiscount(discount);
    }

    private void setDiscount(int discount) throws ArgumentOutOfRangeException {
        if (discount < 1 || discount > 30) throw new ArgumentOutOfRangeException(discount, 1, 30);
        this.discount = discount;
    }

    @Override
    public boolean pay(int amount) {
        double newCredit = credit - (amount - ((discount / 100d) * amount));
        if (newCredit < 0) return false;
        credit = newCredit;
        return true;
    }

    @Override
    public String toString() {
        return "[%d]\t%s\t€%.2f\t%d".formatted(cardId, name, credit, discount) + "%";
    }
}
