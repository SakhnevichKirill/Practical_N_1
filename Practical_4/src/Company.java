import java.util.*;

public class Company {
    private List<Employee> employees;


    public List<Employee> getEmployees() {
        return employees;
    }

    public void hair(Employee employee) {
        if (employees == null) {
            employees = new ArrayList<>();
        }
        employees.add(employee);
    }

    public void hairAll(List<Employee> employeeList) {
        if (employees == null) {
            employees = new ArrayList<>();
        }
        employees.addAll(employeeList);
    }

    public void fire(int pos) {
        employees.remove(pos);
    }

    public int getIncome() {
        Random r = new Random();
        return r.nextInt(20);
    }


    List<Employee> getTopSalaryStaff(int count) {
        ArrayList<Employee> highList= new ArrayList<Employee>();
        if (count < 1) {
            System.out.println("Слишком мало сотрудников");
            return highList;
        }
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.position.getFinalSalary() < o2.position.getFinalSalary()) {
                    return 1;
                }
                else if (o1.position.getFinalSalary() > o2.position.getFinalSalary()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        employees.sort(comparator);
        for (int i = 0; i < count; i++) {
            highList.add(employees.get(i));
        }
        return highList;
    }

    List<Employee> getLowestSalaryStaff(int count) {

        ArrayList<Employee> lowList = new ArrayList<Employee>();
        if (count < 1) {
            System.out.println("Слишком мало сотрудников");
            return lowList;
        }
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.position.getFinalSalary() < o2.position.getFinalSalary()) {
                    return 1;
                }
                else if (o1.position.getFinalSalary() > o2.position.getFinalSalary()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        employees.sort(comparator);
        Collections.reverse(employees);
        for (int i = 0; i < count; i++) {
            lowList.add(employees.get(i));
        }
        return lowList;
    }

    public void generateEmployees() {
        Employee emp;

        //Employee emp1 = new Employee("","", new Operator());
        for (int i = 0; i < 180; i++) {
            if (i%3 == 1) {
                emp = new Employee("Ivan", "Ivanov", new Operator());
                hair(emp);
            } else if (i%3 == 2) {
                emp = new Employee("Alexander", "Trushin", new Operator());
                hair(emp);
            } else {
                emp = new Employee("Boris", "Petrov", new Operator());
                hair(emp);
            }
        }
        Company company = new Company();
        for (int i = 0; i < 10; i++) {
            if (i%3 == 1) {
                emp = new Employee("Alex", "Ivanov", new TopManager(company));
                hair(emp);
            } else if (i%3 == 2) {
                emp = new Employee("Fedor", "Pushkin", new TopManager(company));
                hair(emp);
            } else {
                emp = new Employee("Maria", "Pavlova", new TopManager(company));
                hair(emp);
            }
        }

        for (int i = 0; i < 80; i++) {
            if (i%3 == 1) {
                emp = new Employee("Kate", "Snow", new Manager());
                hair(emp);
            } else if (i%3 == 2) {
                emp = new Employee("John", "Lennon", new Manager());
                hair(emp);
            } else {
                emp =  new Employee("Anvar", "Gubaidullin", new Manager());
                hair(emp);
            }
        }
    }

    public void calcAll(double baseSalary) {

        for (Employee employee : employees) {
            employee.position.calcSalary(baseSalary);
        }
    }

    public void print(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(employees.get(i) + "  " + employees.get(i).position.getFinalSalary() + "  " + employees.get(i).position.getJobTitle() + "\n");
        }
    }

}
