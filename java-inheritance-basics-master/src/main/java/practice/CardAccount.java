package practice;

public class CardAccount extends BankAccount {
    // не забывайте, обращаться к методам и конструкторам родителя
    // необходимо используя super, например, super.put(10D);

    @Override
    public void take(double amountToTake) {
        double onePercent = amountToTake / 100;
        super.take(amountToTake + onePercent);
    }
}
