package trainee.david;

import trainee.david.webshop.controller.WebshopController;
import trainee.david.webshop.view.Interface;

public class Main {

    private static WebshopController controller;

    public static void main(String[] args) {
        controller = new WebshopController();
    }
}