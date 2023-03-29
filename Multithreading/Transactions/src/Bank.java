import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts;
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);

        if (!fromAccount.isBlocked() || !toAccount.isBlocked()) {
            transaction(fromAccount, toAccount, amount);
        }
        if (amount > 50_000) {
            if (isFraud(fromAccountNum, toAccountNum, amount)) {
                fromAccount.blockAccount();
                toAccount.blockAccount();
            }
            transaction(fromAccount, toAccount, amount);
        }
    }

    public void transaction(Account fromAccount, Account toAccount, long amount) {
        if (fromAccount.withdrawMoney(amount)) {
            toAccount.putMoney(amount);
        }
    }

    public long getBalance(String accountNum) {
        Account account = accounts.get(accountNum);
        return account.getMoney();
    }

    public long getSumAllAccounts() {
        long sumAllAccounts = 0;
        for (int i = 1; i <= accounts.size(); i++) {
            sumAllAccounts = sumAllAccounts + accounts.get(i).getMoney();
        }
        return sumAllAccounts;
    }
}
