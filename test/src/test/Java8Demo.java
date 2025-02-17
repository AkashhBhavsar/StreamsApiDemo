package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<Employee>();

		list.add(new Employee(1, "Akash", 10000, "IT"));
		list.add(new Employee(1, "John", 20000, "HR"));
		list.add(new Employee(1, "ABCD", 10000, "IT"));
		list.add(new Employee(1, "XYZZ", 20000, "HR"));
		
		//Getting highest salary from each department
		Map<String,Optional<Employee>> highestSalary= list.stream()
				.collect(Collectors.groupingBy(Employee::getDept,
						Collectors.collectingAndThen(Collectors.toList(),
		employ->employ.stream().sorted(Comparator.comparingInt(Employee::getSalary)
				.reversed()).findFirst())));
		
				
		highestSalary.forEach((department, employeeOptional) ->{
			System.out.println("Department: " + department);
			employeeOptional.ifPresentOrElse(employee -> System.out.println(employee.getName() +" : "+employee.getSalary()), // Using
																										// toString()
					() -> System.out.println("No second highest salary found in this department."));
			System.out.println("--------------------");
		});
		//.filter(employee->employee.getName().startsWith("A"))
		//Getting names starting with A from each dept
		Map<String, List<Employee>>namestartingwithA = list.stream()
				.filter(employee->employee.getName().startsWith("A"))
				.collect(Collectors.groupingBy(Employee::getDept));
		
		namestartingwithA.forEach((department, employeeOptional) ->{
			System.out.println("Department: " + department);
			employeeOptional.ifPresentOrElse(employee -> System.out.println(employee.getName()), // Using
																										// toString()
					() -> System.out.println("No name found."));
			System.out.println("--------------------");
		});
	}

}
