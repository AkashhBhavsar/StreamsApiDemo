package test;

public class Employee {

	private int empId;
	private String name;
	private Integer salary;
	private String dept;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public Employee(int empId, String name, Integer salary, String dept) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}

}
