package Company;

public class Company {
    private String company;
    private String income;

    Company(){}

    Company(String company, String income) {
        this.company = company;
        this.income = income;
    }

    public String getCompany() {
        return company;
    }

    public String getIncome() {
        return income;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setIncome(String income) {
        this.income = income;
    }
}
