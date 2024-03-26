package trainee.david.bank;

public class BalanceException extends Exception {

    @Override
    public String getMessage() {
        return "Not enough balance in the account to perform this operation";
    }
}
