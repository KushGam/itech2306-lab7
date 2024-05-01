import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    private BankAccount account1;
    private BankAccount account2;
    private SavingsAccount savingsAccount1;
    private SavingsAccount savingsAccount2;

    @BeforeEach
    void setUp() {
        account1 = new BankAccount(1000, "John Doe");
        account2 = new BankAccount(500, "Jane Doe");
        savingsAccount1 = new SavingsAccount(1500, "Jim Beam", 10, 0.01); // Assuming a withdrawal fee of $10 and interest rate of 1%
        savingsAccount2 = new SavingsAccount(2000, "Jill Scott", 20, 0.02); // Assuming a withdrawal fee of $20 and interest rate of 2%
    }
    @Test
    void testTransferBetweenBankAccounts() {
        account1.transfer(account2, 200);
        assertEquals(800, account1.getBalance(), "Balance should decrease by the transfer amount");
        assertEquals(700, account2.getBalance(), "Balance should increase by the transfer amount");
    }
    @Test
    void testTransferFromSavingsToBankAccount() {
        // Test when fee allows transfer
        savingsAccount1.transfer(account1, 1400); // Assuming the fee is included in the withdraw method
        assertEquals(90, savingsAccount1.getBalance(), "Balance should decrease by transfer amount and fee (1500 - 1400 - 10 for the fee)");
        assertEquals(2400, account1.getBalance(), "Balance should increase by the transfer amount");

        // Test when fee disallows transfer
        savingsAccount1.transfer(account1, 1450); // Not enough balance for transfer + fee
        assertEquals(90, savingsAccount1.getBalance(), "Balance should remain unchanged due to insufficient funds after fee");
        assertEquals(2400, account1.getBalance(), "Balance should remain unchanged due to failed transfer");
    }

    @Test
    void testTransferFromBankAccountToSavingsAccount() {
        account1.transfer(savingsAccount1, 200);
        assertEquals(800, account1.getBalance(), "Balance should decrease by the transfer amount");
        assertEquals(1700, savingsAccount1.getBalance(), "Balance should increase by the transfer amount");
    }

    @Test
    void testTransferBetweenSavingsAccounts() {
        savingsAccount1.transfer(savingsAccount2, 1000);
        assertEquals(490, savingsAccount1.getBalance(), "Balance should decrease by transfer amount and fee");
        assertEquals(3000, savingsAccount2.getBalance(), "Balance should increase by the transfer amount");
    }
}