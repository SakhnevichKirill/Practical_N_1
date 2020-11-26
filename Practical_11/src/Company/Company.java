package Company;

public class Company {
    private String company;
    private int income = 0;
    private int expenses = 0;

    public Company(){}

    Company(String company, int income, int expenses) {
        this.company = company;
        this.income = income;
        this.expenses = expenses;
    }

    public String getCompany() {
        return company;
    }

    public int getIncome() {
        return income;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void addIncome(int income) {
        this.income += income;
    }

    public void addExpenses(int expenses) {
        this.expenses += expenses;
    }

    @Override
    public String toString() {
        return "Company{" +
                "company='" + company + '\'' +
                ", income=" + income +
                ", expenses=" + expenses +
                '}';
    }
}
