package trainee.david;

import trainee.david.other.H6;
import trainee.david.other.H8;
import trainee.david.other.PersonDiedException;
import trainee.david.webshop.controller.WebshopController;

public class Main {

    private static WebshopController controller;

    public static void main(String[] args) throws PersonDiedException {
//        controller = new WebshopController();
        H8.run();
    }
}