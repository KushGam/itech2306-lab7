public class BankAccount {
    private double balance;
    private String owner;

    // Constructor to initialize the balance and owner
    public BankAccount(double initialBalance, String owner) {
        this.balance = initialBalance;
        this.owner = owner;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Getter method for the balance
    public double getBalance() {
        return balance;
    }

    // Getter method for the owner
    public String getOwner() {
        return owner;
    }
}