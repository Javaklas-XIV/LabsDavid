package trainee.david.bank;

import java.math.BigDecimal;

public class Account {

    private final int accountNumber;
    private BigDecimal balance;
    private BigDecimal interestRate;            // percentage

    public Account(int accountNumber, double interestRate) {
        this(accountNumber, interestRate, 0.0);
    }

    public Account(int accountNumber, double interestRate, double balance) {
        this.accountNumber = accountNumber;
        this.interestRate = BigDecimal.valueOf(interestRate);
        this.balance = BigDecimal.valueOf(balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getInterestRate() {
        return interestRate.doubleValue();
    }

    public void setInterestRate(double interestRate) {
        if (interestRate > 0 && interestRate <= 100) {
            this.interestRate = BigDecimal.valueOf(interestRate);
        }
    }

    public double checkBalance() {
        return balance.doubleValue();
    }

    public void deposit(double amount) {
        balance = balance.add(BigDecimal.valueOf(amount));
    }

    public void withdraw(double amount) throws BalanceException {
        if (amount < balance.doubleValue()) balance = balance.subtract(BigDecimal.valueOf(amount));
        else throw new BalanceException();
    }

    public double calculateYearlyInterest() {
        return (balance.multiply(interestRate.divide(BigDecimal.valueOf(100)))).doubleValue();
    }

    @Override
    public String toString() {
        return "Account " + accountNumber + ": " + balance + " - Interest: " + interestRate + "%";
    }
}
