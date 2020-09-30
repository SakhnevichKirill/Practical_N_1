import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        company.generateEmployees(); // генерирую сотрудников Оп. 180; Мен. 80; ТопМен. 10.

        company.calcAll(); // считаем зарплаты все сотрудников с базовой ставкой от 25000 до 35000 рандомно



        System.out.println();

        List<Employee> high = company.getTopSalaryStaff(10);

        List<Employee> low = company.getLowestSalaryStaff(30);

        System.out.println("Топ 10, самые высокие зп\nЗП: \t\t\t Имя,\t\t   Фамилия: \t\t\t Должность");

        for (Employee item : high) {
            System.out.println(item.position.getFinalSalary() + " " + item + "  " + item.position.getJobTitle() + "\n");
        }
        System.out.println("Топ 30, самые низкие зп\nЗП: \t\t\t Имя,\t\t   Фамилия: \t\t\t Должность");

        for (Employee value : low) {
            System.out.println(value.position.getFinalSalary() + " " + value + "  " + value.position.getJobTitle() +"\n");
        }

        for (int i = 0; i < company.getEmployees().size(); i++) {
            if (i%2 == 1) {
                company.fire(i);
            }
        }

        System.out.println("___после сокращения штаба_____________________");
        ///////////////
        high = company.getTopSalaryStaff(10);

        low = company.getLowestSalaryStaff(30);

        System.out.println("Топ 10, самые высокие зп\nЗП: \t\t\t Имя,\t\t   Фамилия: \t\t\t Должность");

        for (Employee employee : high) {
            System.out.println(employee.position.getFinalSalary() + " " + employee + "  " + employee.position.getJobTitle() + "\n");
        }
        System.out.println("Топ 30, самые низкие зп\nЗП: \t\t\t Имя,\t\t   Фамилия: \t\t\t Должность");

        for (Employee employee : low) {
            System.out.println(employee.position.getFinalSalary() + " " + employee + "  " + employee.position.getJobTitle() +"\n");
        }

        System.out.println("__________________________________ALL");
        company.print(181); // нарошно ввожу число большее размера списка для обработку этой ситуации
        company.print(130);
    }
}
