package trainee.david.webshop.view;

public class LoginView extends Interface {

    private final InputListener inputListener;

    public LoginView(InputListener inputListener){
        this.inputListener = inputListener;
    }

    @Override
    public void show() {
        printMenuHeader("Login");
        String username = getUserInput("Enter a username: ");
        String placeOfResidence = getUserInput("Enter your place of residence: ");

        inputListener.onLoginComplete(username, placeOfResidence);
    }
}
