public class Account {
    private long money;
    private String accNumber;
    private boolean isBlocked = false;

    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
    }

    public void setIdBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public synchronized void blockAccount() {
        isBlocked = true;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public synchronized boolean withdrawMoney(long money) {
        if (this.money >= money) {
            this.money -= money;
            return true;
        }
        return false;
    }

    public synchronized void putMoney(long money) {
        this.money += money;
    }

}
