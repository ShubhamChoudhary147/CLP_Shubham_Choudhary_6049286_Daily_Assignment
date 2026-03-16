package Assignment5_13;

public class Employee {

    private int employeeId;
    private String employeeName;
    private double salary;
    private int age;

    public Employee() {}

    public int getEmployeeId() { return employeeId; }
    public String getEmployeeName() { return employeeName; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee [empAge=" + age
             + ", empId=" + employeeId
             + ", empName=" + employeeName
             + ", empSalary=" + salary + "]";
    }
}