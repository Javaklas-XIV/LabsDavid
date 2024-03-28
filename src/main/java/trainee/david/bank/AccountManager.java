package trainee.david.bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class AccountManager implements Iterable<Account> {

    private final List<Account> accounts;
    private int accountIdCount;

    public AccountManager() {
        this.accounts = new ArrayList<>();
        accountIdCount = 0;
    }

    @Override
    public Iterator<Account> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < accounts.size();
            }

            @Override
            public Account next() {
                return accounts.get(index++);
            }
        };
    }

    public Account add(int interest) {
        Account newAccount = new Account(accountIdCount++, interest);
        accounts.add(newAccount);
        return newAccount;
    }

    public void remove(int accountNumber) {
        accounts.removeIf(account -> account.getAccountNumber() == accountNumber);
    }

    public Optional<Account> find(int accountNumber) {
        return accounts.stream()
                .filter(account -> account.getAccountNumber() == accountNumber)
                .findFirst();
    }

    public List<Account> getAll() {
        return accounts;
    }

}
