import java.util.Random;

public class TopManager implements EmployeePosition {
    private double finalSalary;
    private final Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    public double getFinalSalary() {
        return finalSalary;
    }

    @Override
    public String getJobTitle() {
        return "Top-Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        if (company.getIncome() > 10) {
            return finalSalary = baseSalary*2.5;
        } else {
            return finalSalary = baseSalary;
        }
    }
}
