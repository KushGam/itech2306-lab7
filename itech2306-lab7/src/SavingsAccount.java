public class SavingsAccount extends BankAccount {
    private double withdrawalFee;
    private double interestRate;

    // Constructor
    public SavingsAccount(double initialBalance, String owner, double withdrawalFee, double interestRate) {
        super(initialBalance, owner);  // Call the superclass constructor
        this.withdrawalFee = withdrawalFee;
        this.interestRate = interestRate;
    }

    // Getter for the withdrawal fee
    public double getWithdrawalFee() {
        return withdrawalFee;
    }

    // Getter for the interest rate
    public double getInterestRate() {
        return interestRate;
    }

    // Override the withdraw method to include a withdrawal fee
    @Override
    public boolean withdraw(double amount) {
        double totalAmount = amount + withdrawalFee;
        if (totalAmount <= getBalance()) {
            return super.withdraw(totalAmount);
        }
        return false;
    }

   
 // Method to apply interest, rounding the daily interest to the nearest cent
    public void applyInterest() {
        double annualInterest = getBalance() * interestRate;
        double dailyInterest = annualInterest / 365;
        double roundedDailyInterest = Math.round(dailyInterest * 100) / 100.0;  // Round to the nearest cent
        deposit(roundedDailyInterest);
    }
}