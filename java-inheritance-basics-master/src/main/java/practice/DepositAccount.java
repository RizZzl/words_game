package practice;

import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome;

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
        lastIncome = LocalDate.now();
    }

    @Override
    public void take(double amountToTake) {
        boolean monthAgo = lastIncome.getMonth().equals(LocalDate.now().getMonth());
        boolean yearAgo = lastIncome.getYear() != LocalDate.now().getYear();
        if (!monthAgo || yearAgo) {
            super.take(amountToTake);
        }
    }
}
