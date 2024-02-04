package ser;

public class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= userAccount.getBalance()) {
            userAccount.setBalance(userAccount.getBalance() - amount);
            System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            userAccount.setBalance(userAccount.getBalance() + amount);
            System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public double checkBalance() {
        return userAccount.getBalance();
    }
}
