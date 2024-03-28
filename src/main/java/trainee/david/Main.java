package trainee.david;
import trainee.david.bank.Account;
import trainee.david.bank.AccountManager;
import trainee.david.webshop.controller.WebshopController;

public class Main {

    private static WebshopController controller;

    public static void main(String[] args) {
//        controller = new WebshopController();

        AccountManager manager = new AccountManager();
        manager.add(3);
        manager.add(4);
        manager.add(2);

        for (Account account : manager){
            System.out.println(account);
        }
    }
}