import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        company.generateEmployees(); // генерирую 180+80+10 сотрудников

        company.calcAll(1000); // считаем зарплаты все сотрудников с базовой ставкой

        company.print(10); // для наглядности



        System.out.println();

        List<Employee> high = company.getTopSalaryStaff(10);

        List<Employee> low = company.getLowestSalaryStaff(30);

        System.out.println("10 самых высоких зп");

        for (Employee item : high) {
            System.out.println(item.position.getFinalSalary() + " " + item + "  " + item.position.getJobTitle() + "\n");
        }
        System.out.println("30 самых низких \n");

        for (Employee value : low) {
            System.out.println(value.position.getFinalSalary() + " " + value + "  " + value.position.getJobTitle() +"\n");
        }

        for (int i = 0; i < company.getEmployees().size(); i++) {
            if (i%2 == 0) {
                company.fire(i);
            }
        }

        System.out.println("___после сокращения штаба_____________________");
        ///////////////
        high = company.getTopSalaryStaff(10);

        low = company.getLowestSalaryStaff(30);

        System.out.println("10 самых высоких ");

        for (Employee employee : high) {
            System.out.println(employee.position.getFinalSalary() + " " + employee + "  " + employee.position.getJobTitle() + "\n");
        }
        System.out.println("10 самых низких_____\n");

        for (Employee employee : low) {
            System.out.println(employee.position.getFinalSalary() + " " + employee + "  " + employee.position.getJobTitle() +"\n");
        }

        System.out.println("__________________________________ALL");
        company.print(130);
    }
}
