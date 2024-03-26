package trainee.david.webshop.view;

public class MainView extends Interface {

    private final InputListener inputListener;
    private final static String[] menuOptions = {
            "Login",
            "Browse",
            "Order",
            "Exit"
    };

    public MainView(InputListener inputListener){
        this.inputListener = inputListener;
    }

    @Override
    public void show() {
        printMenuHeader("Welcome");
        for (int index = 0; index < menuOptions.length; index++){
            String line = "[%d] %s".formatted(index, menuOptions[index]);
            printLine(line);
        }

        String input;
        int menuChoice;
        do {
            input = getUserInput("Enter an option: ");
        } while ((menuChoice = validMenuInput(input, menuOptions.length)) == -1);

        inputListener.onMainComplete(menuChoice);
    }
}
