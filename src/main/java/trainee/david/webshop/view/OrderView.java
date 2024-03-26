package trainee.david.webshop.view;

import trainee.david.webshop.model.Item;
import trainee.david.webshop.model.Order;

import java.util.GregorianCalendar;
import java.util.List;

public class OrderView extends Interface {

    private final InputListener inputListener;
    private final List<Item> allItems;

    public OrderView(InputListener inputListener, List<Item> allItems){
        this.inputListener = inputListener;
        this.allItems = allItems;
    }

    @Override
    public void show() {
        printMenuHeader("Select items");

        Order newOrder = new Order(new GregorianCalendar());

        do {
            newOrder.addItem(allItems.get(selectItem()));
        } while (orderMore());

        printMenuHeader("Order");
        inputListener.onOrderComplete(newOrder);
    }

    private boolean orderMore(){
        String answer;
        do {
            answer = getUserInput("Would you like to order another item? [y/n]: ");
        } while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"));
        return answer.equals("y");
    }

    private int selectItem(){
        String itemIdInput;
        int itemId;
        do {
            itemIdInput = getUserInput("Enter the item ID you'd like to order: ");
        } while ((itemId = validMenuInput(itemIdInput, allItems.size())) == -1);

        return itemId;
    }
}
