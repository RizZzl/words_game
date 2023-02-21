package practice_1;

import java.util.*;

public class Company {
    public static double income;
    public static ArrayList<Employee> employeeArrayList = new ArrayList();

    public Company() {
    }

    public void setIncome(double income) {
        Company.income = income;
    }

    public static double getIncome() {
        return income;
    }

    public void hire(Employee employee) {
        employeeArrayList.add(employee);
    }

    public void hireAll(Collection<Employee> employeeList) {
        employeeArrayList.addAll(employeeList);
    }

    public void fire(Employee employee) {
        employeeArrayList.remove(employee);
    }

    public List<Employee> getTopSalaryStaff(int count) {
        return getFilteredLimitedList(count, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return (int) (o2.getMonthSalary() - o1.getMonthSalary());
            }
        });
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        return getFilteredLimitedList(count, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getMonthSalary() - o2.getMonthSalary());
            }
        });
    }


    private List<Employee> getFilteredLimitedList(int count, Comparator<Employee> comparator) {
        List<Employee> copyList = new ArrayList(employeeArrayList);
        Collections.sort(copyList, comparator);
        List<Employee> result = new ArrayList();

        for(int i = 0; i < count; ++i) {
            result.add((Employee)copyList.get(i));
        }

        return result;
    }

    public int countEmployees() {
        return employeeArrayList.size();
    }

    public List<Employee> getEmployees() {
        return employeeArrayList;
    }
}
