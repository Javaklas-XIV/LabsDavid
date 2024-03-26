package trainee.david.bank;

import java.util.List;
import java.util.Optional;

public class Bank {

    private final String bankName;
    private final int defaultInterestRate = 3;
    private final AccountManager accountManager;

    public Bank(String bankName, AccountManager accountManager) {
        this.bankName = bankName;
        this.accountManager = accountManager;
    }

    public Bank(String bankName) {
        this(bankName, new AccountManager());
    }

    public static void transferMoney(Account fromAccount, Account toAccount, double amount) {
        try {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        } catch (BalanceException balanceException) {
            balanceException.printStackTrace();
        }
    }

    public List<Account> getAccounts() {
        return accountManager.getAll();
    }

    public Account find(int accountNumber) {
        Optional<Account> account = accountManager.find(accountNumber);
        return account.orElse(null);
    }

    public Account createNewAccount() {
        return createNewAccount(defaultInterestRate);
    }

    public Account createNewAccount(int interestRate) {
        return accountManager.add(interestRate);
    }

    public void printAccounts() {
        for (Account account : getAccounts()) {
            System.out.println(account);
        }
    }

    @Override
    public String toString() {
        return "%s - Accounts: %d".formatted(bankName, getAccounts().size());
    }
}
