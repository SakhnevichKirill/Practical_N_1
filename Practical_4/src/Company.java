import java.util.*;

public class Company {
    private List<Employee> employees;


    private Random r = new Random();


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

    public int employeeUtility() {
        return r.nextInt(20);
    }


    List<Employee> getTopSalaryStaff(int count) {
        ArrayList<Employee> topList= new ArrayList<Employee>();
        if (count < 1) {
            System.out.println("Сотрудников нет");
            return topList;
        }
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                double O1 = o1.position.getFinalSalary();
                double O2 = o2.position.getFinalSalary();
                if (O1 < O2) {
                    return 1;
                }
                else if (O1 > O2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        employees.sort(comparator);
        for (int i = 0; i < count; i++) {
            topList.add(employees.get(i));
        }
        return topList;
    }

    List<Employee> getLowestSalaryStaff(int count) {
        ArrayList<Employee> lowList = new ArrayList<Employee>();
        if (count < 1) {
            System.out.println("Сотрудников нет");
            return lowList;
        }
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                double O1 = o1.position.getFinalSalary();
                double O2 = o2.position.getFinalSalary();
                if (O1 < O2) {
                    return 1;
                }
                else if (O1 > O2) {
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
        Company company = new Company();

        for (int i = 0; i < 180; i++) {
            if (i%3 == 1) {
                emp = new Employee("Sasha", "Ivanov", new Operator(company));
                hair(emp);
            } else if (i%3 == 2) {
                emp = new Employee("Ruslan", "Chencov", new Operator(company));
                hair(emp);
            } else {
                emp = new Employee("Roman", "Petrov", new Operator(company));
                hair(emp);
            }
        }
        for (int i = 0; i < 10; i++) {

            if (i%3 == 1) {
                emp = new Employee("Peter", "Darlov", new TopManager(company));
                hair(emp);
            } else if (i%3 == 2) {
                emp = new Employee("John", "Kelvin", new TopManager(company));
                hair(emp);
            } else {
                emp = new Employee("Maria", "Pavlova", new TopManager(company));
                hair(emp);
            }

        }

        for (int i = 0; i < 80; i++) {
            if (i%3 == 1) {
                emp = new Employee("Kate", "Romero", new Manager(company));
                hair(emp);
            } else if (i%3 == 2) {
                emp = new Employee("Fedor", "Rurikov", new Manager(company));
                hair(emp);
            } else {
                emp =  new Employee("Kirill", "Sakhnevich", new Manager(company));
                hair(emp);
            }
        }
    }

    public void calcAll() {
        for (Employee employee : employees) {
            employee.position.calcSalary(r.nextInt((35000 - 25000) + 1) + 25000);
        }
    }

    public void print(int n) {
        if (n > employees.size())
            System.out.println("Размер введенный для вывода больше размера списка сотрудников");
        else {
            for (int i = 0; i < n; i++) {
                System.out.println(employees.get(i) + "  " + employees.get(i).position.getFinalSalary() + "  " + employees.get(i).position.getJobTitle() + "\n");
            }
        }

    }

}
