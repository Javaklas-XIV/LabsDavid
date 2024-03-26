package trainee.david.webshop.view;

import trainee.david.webshop.model.Order;

public interface InputListener {

    void onMainComplete(int option);
    void onLoginComplete(String userName, String placeOfResidence);
    void onBrowseComplete();
    void onOrderComplete(Order newOrder);

}
