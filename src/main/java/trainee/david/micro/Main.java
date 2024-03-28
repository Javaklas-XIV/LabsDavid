package trainee.david.micro;

import java.util.Scanner;

public class Main {

    private final static Card[] cards;
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);

        try {
            cards = new Card[]{
                    new GoldCard(123, "David", 999.99, 30),
                    new GoldCard(234, "Alice", 888.88, 25),
                    new RegularCard(345, "Bob", 777.77)
            };
        } catch (ArgumentOutOfRangeException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        while (true){
            System.out.println("CardID\tName\tAmount\tDiscount");
            for (Card card : cards) System.out.println(card);
            System.out.print("\nEnter a card ID: ");
            int cardIdInput = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter the amount to pay: ");
            int amountInput = Integer.parseInt(scanner.nextLine());

            boolean cardAvailable = false;
            for (Card card : cards){
                if (card.cardId == cardIdInput) {
                    cardAvailable = true;
                    if (!card.pay(amountInput)){
                        System.out.println("Unable to complete payment");
                    }
                    break;
                }
            }
            if (!cardAvailable) System.out.println("Unable to find card with ID: " + cardIdInput);
        }
    }

}
