public class Employee {
    protected String name;
    protected String surname;
    protected EmployeePosition position;

    public Employee(String name, String surname, EmployeePosition position) {
        this.name = name;
        this.surname = surname;
        this.position = position;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

}
