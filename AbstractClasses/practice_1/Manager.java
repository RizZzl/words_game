package practice_1;

public class Manager implements Employee {
    private final double FIX_SALARY = 70000.0;
    public final double MIN = 115000.0;
    public final double MAX = 140000.0;
    public double salary;
    double bonus = (Math.random() * 25001.0 + 115000.0) / 100.0 * 5.0;

    public double getMonthSalary() {
        this.salary = 70000.0 + this.bonus;
        return this.salary;
    }
}
