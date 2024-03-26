package trainee.david.webshop.controller;

import trainee.david.webshop.model.Customer;
import trainee.david.webshop.model.Item;
import trainee.david.webshop.model.Order;
import trainee.david.webshop.model.repo.CatalogRepo;
import trainee.david.webshop.model.repo.CustomerRepo;
import trainee.david.webshop.model.repo.ItemRepo;
import trainee.david.webshop.model.repo.OrderRepo;
import trainee.david.webshop.view.*;

import java.util.Optional;

public class WebshopController implements InputListener {

    private final MainView mainView;
    private final LoginView loginView;
    private final BrowseView browseView;
    private final OrderView orderView;

    private final CatalogRepo catalogRepo;
    private final CustomerRepo customerRepo;
    private final ItemRepo itemRepo;
    private final OrderRepo orderRepo;

    private int customerId;
    private Customer activeCustomer;

    public WebshopController() {
        customerRepo = new CustomerRepo();
        itemRepo = new ItemRepo();
        catalogRepo = new CatalogRepo(itemRepo);
        orderRepo = new OrderRepo();
        customerId = 0;

        mainView = new MainView(this);
        loginView = new LoginView(this);
        browseView = new BrowseView(this, catalogRepo.getAll());
        orderView = new OrderView(this, itemRepo.getAll());

        mainView.show();
    }

    @Override
    public void onMainComplete(int option) {
        switch (option) {
            case 0 -> loginView.show();
            case 1 -> browseView.show();
            case 2 -> orderView.show();
        }
    }

    @Override
    public void onLoginComplete(String userName, String placeOfResidence) {
        System.out.printf("Welcome %s\n", userName);
        // add customer to repo
        Optional<Customer> existingCustomer = customerRepo.find(userName);
        if (existingCustomer.isPresent()) {
            activeCustomer = existingCustomer.get();
        } else {
            Customer newCustomer = new Customer(customerId++, userName, placeOfResidence);
            activeCustomer = newCustomer;
            customerRepo.add(newCustomer);
        }

        // return to the main menu
        mainView.show();
    }

    @Override
    public void onBrowseComplete() {
        // return to the main menu
        mainView.show();
    }

    @Override
    public void onOrderComplete(Order newOrder) {
        // Add the order to the customer & repo
        if (activeCustomer != null) {
            activeCustomer.addOrder(newOrder);
            orderRepo.add(newOrder);

            // Print the total order
            for (Item item : newOrder.getItems().keySet()) {
                System.out.println(newOrder.getItems().get(item) + "x " + item);
            }
            System.out.printf("- Selected %d items with a total price of €%.2f\n",
                    newOrder.getItems().size(),
                    newOrder.getTotalPrice());
        }
        else {
            System.out.println("No user logged in");
        }

        // return to the main menu
        mainView.show();
    }

}
