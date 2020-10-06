import java.util.Random;

public class Manager implements EmployeePosition {
    private double finalSalary;
    private Company company;
    private double profitManag;


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

        profitManag = (double) r.nextInt((140000 - 115000) + 1) + 115000;
        company.refProfitCompany(profitManag);

        finalSalary = (double) r.nextInt(((int)(baseSalary+profitManag*0.05) - (int)baseSalary) + 1) + baseSalary;

        return finalSalary;
    }

}
