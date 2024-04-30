import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount(1000, "John Doe");
    }

    @Test
    public void testGetMethods() {
        assertEquals(1000, account.getBalance(), 0.01, "Expected balance is 1000");
        assertEquals("John Doe", account.getOwner(), "Account should belong to John Doe");
    }

    @Test
    public void testDepositIncreasesBalance() {
        account.deposit(500);
        assertEquals(1500, account.getBalance(), 0.01, "Balance should be 1500 after depositing 500");
    }

    @Test
    public void testDepositDoesNothingWithNegativeAmount() {
        account.deposit(-500);
        assertEquals(1000, account.getBalance(), 0.01, "Balance should remain unchanged");
    }

    @Test
    public void testWithdrawDecreasesBalance() {
        assertTrue(account.withdraw(200), "Withdraw should return true");
        assertEquals(800, account.getBalance(), 0.01, "Balance should be 800 after withdrawing 200");
    }

    @Test
    public void testWithdrawDoesNothingWithNegativeAmount() {
        assertFalse(account.withdraw(-300), "Withdraw should return false");
        assertEquals(1000, account.getBalance(), 0.01, "Balance should remain unchanged");
    }

    @Test
    public void testWithdrawDoesNothingIfAmountExceedsBalance() {
        assertFalse(account.withdraw(1100), "Withdraw should return false as amount exceeds balance");
        assertEquals(1000, account.getBalance(), 0.01, "Balance should remain unchanged");
    }
}