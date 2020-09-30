import java.util.Random;

public class Manager implements EmployeePosition {
    private double finalSalary;
    private Company company;

    public Manager (Company company){
        this.company = company;
    }


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
        if (company.employeeUtility() > 10)
            finalSalary = (double) r.nextInt((60000 - (int)baseSalary) + 1) + baseSalary + 5000;
        else finalSalary = (double) r.nextInt((60000 - (int)baseSalary) + 1) + baseSalary;
        return finalSalary;
    }

}
