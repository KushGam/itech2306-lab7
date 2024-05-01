public class BankAccount {
    private double balance;
    private String owner;

    public BankAccount(double initialBalance, String owner) {
        this.balance = initialBalance;
        this.owner = owner;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    public void transfer(BankAccount otherAccount, double amount) {
        if (this != otherAccount && this.withdraw(amount)) {
            otherAccount.deposit(amount);
        }
    }
}