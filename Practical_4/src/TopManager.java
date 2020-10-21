import java.util.Random;

public class TopManager implements EmployeePosition {
    private double finalSalary;
    private final Company company;
    private boolean f;

    public TopManager(Company company) {
        this.company = company;
    }

    public void setF(){
        double temp = company.getProfitCompany();
        if (temp > 10000000)
            f = true;
        else f = false;
    }


    @Override
    public double getFinalSalary() {
        return finalSalary;
    }

    @Override
    public String getJobTitle() {
        return "Top-Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        Random r = new Random();
        setF();
        return company.getProfitCompany() > 10000000 ? baseSalary*1.5 : baseSalary;

    }
}
