package trainee.david.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BankTest {

    @InjectMocks
    private Bank rabo, ing;

    @Mock
    private AccountManager mockManager;

    @BeforeEach
    void setUp() {
        Mockito.lenient().when(mockManager.add(Mockito.anyInt()))
                .thenReturn(new Account(5, 4, 2000));
        Mockito.lenient().when(mockManager.find(Mockito.anyInt()))
                .thenReturn(Optional.of(new Account(3, 3, 3000)));
    }

    @Test
    void createAccounts() {
        Account testAccount = rabo.createNewAccount();

        Mockito.verify(mockManager).add(Mockito.anyInt());
        assertEquals(5, testAccount.getAccountNumber());
    }

    @Test
    void testDeposit() {
        Account account = rabo.createNewAccount();
        account.deposit(400);
        assertEquals(2400, account.checkBalance());
    }

    @Test
    void testWithdraw() throws BalanceException {
        Account account = rabo.find(0);
        Mockito.verify(mockManager).find(Mockito.anyInt());

        assertEquals(3000, account.checkBalance());
        account.withdraw(200);
        assertEquals(2800, account.checkBalance());
    }

    @Test
    void testTransfers() {
        Account raboAccount = rabo.createNewAccount();
        Account ingAccount = ing.find(0);

        Bank.transferMoney(raboAccount, ingAccount, 300);

        assertEquals(1700, raboAccount.checkBalance());
        assertEquals(3300, ingAccount.checkBalance());
    }

    @Test
    void testInterest() {
        Account testAccount = rabo.createNewAccount(4);
        double interest = testAccount.calculateYearlyInterest();
        assertEquals(80, interest);
    }
}