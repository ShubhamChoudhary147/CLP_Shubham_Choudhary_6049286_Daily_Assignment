package Assignment5_11;

public class Employee {
	private int employeeId;
	private String employeeName;
	private double salary;
	private String businessUnit;
	private int age;
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public double getSalary() {
		return salary;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public int getAge() {
		return age;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void show() {
		System.out.println("Employee details");
		System.out.println("-------------------------------------------");
		System.out.println("Employee ID : " +employeeId);
		System.out.println("Employee Name: "+employeeName);
		System.out.println("Employee Salary : " +salary);
		System.out.println("Employee BU : " +businessUnit );
		System.out.println("Employee Age : "+age);
	}

}