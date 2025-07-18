import java.time.LocalDateTime;

public class BankAccount {
    private String ownerName;
    private int balance;
    private LocalDateTime openDate;
    private boolean isBlocked;

    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0;
        this.openDate = LocalDateTime.now();
        this.isBlocked = false;
    }

    public boolean deposit(int amount) {
        if (isBlocked || amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(int amount) {
        if (isBlocked || amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean transfer(BankAccount otherAccount, int amount) {
        if (isBlocked || otherAccount.isBlocked || amount <= 0 || amount > balance) {
            return false;
        }

        if (this.withdraw(amount)) {
            return otherAccount.deposit(amount);
        }
        return false;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getBalance() {
        return balance;
    }

    public LocalDateTime getOpenDate() {
        return openDate;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public void setOpenDate(LocalDateTime openDate) {
        this.openDate = openDate;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}