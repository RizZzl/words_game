package practice_1;

public class TopManager implements Employee {
    private final double FIX_SALARY = 150000.0;
    public final double bonus = FIX_SALARY * 1.5;
    private double salary;



    public double getMonthSalary() {
        if (Company.getIncome() > 10_000_000) {
            this.salary = FIX_SALARY + bonus;
        } else {
            this.salary = FIX_SALARY;
        }

        return this.salary;
    }
}
