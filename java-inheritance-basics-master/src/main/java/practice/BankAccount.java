package practice;

public class BankAccount {
  protected double moneyInAccount = 0;

  public double getAmount() {
    return moneyInAccount;
  }

  public void put(double amountToPut) {
    if (amountToPut > 0) {
      moneyInAccount += amountToPut;
    }
  }

  public void take(double amountToTake) {
    if (moneyInAccount >= amountToTake) {
      moneyInAccount -= amountToTake;
    }
  }
}
