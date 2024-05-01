import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    private SavingsAccount account;

    @BeforeEach
    void setUp() {
        // Initialize your object before each test
        account = new SavingsAccount(1000, "John Doe", 5, 0.012); // Example parameters
    }

    @Test
    void testDeposit() {
        account.deposit(200);
        assertEquals(1200, account.getBalance(), "Balance should be updated after deposit");
    }

    @Test
    void testWithdrawal() {
        assertTrue(account.withdraw(200), "Withdrawal should be successful");
        assertEquals(795, account.getBalance(), "Balance should reflect the withdrawal and fee");
    }

    @Test
    void testApplyInterest() {
        account.applyInterest();
        assertTrue(account.getBalance() > 1000, "Balance should increase after applying interest");
    }
}