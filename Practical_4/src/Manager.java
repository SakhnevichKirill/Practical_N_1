import java.util.Random;

public class Manager implements EmployeePosition {
    private double finalSalary;

    public double getFinalSalary() {
        return finalSalary;
    }


    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        Random r = new Random();
        return finalSalary = (r.nextInt(25000) + 115000)*0.05 + baseSalary;
    }

}
