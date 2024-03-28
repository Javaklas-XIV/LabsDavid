package trainee.david.micro;

public class RegularCard extends Card {

    public RegularCard(int cardId, String name, double credit) {
        super(cardId, name, credit);
    }

    @Override
    public boolean pay(int amount) {
        double newCredit = credit - amount;
        if (newCredit < 0) return false;
        credit = newCredit;
        return true;
    }

}
