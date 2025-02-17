package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {

	public static void main(String args[]) {

		List<Employee> emp = new ArrayList<Employee>();

		emp.add(new Employee(1, "Akash", 10000, "IT"));
		emp.add(new Employee(1, "John", 20000, "HR"));
		emp.add(new Employee(1, "ABCD", 10000, "IT"));
		emp.add(new Employee(1, "XYZZ", 20000, "HR"));

		//Getting highest salary from the list of Employees
		Map<String, Optional<Employee>> secondHighestByDept = emp.stream()
				.collect(Collectors.groupingBy(Employee::getDept,
						Collectors.collectingAndThen(Collectors.toList(),
								emp1 -> emp1.stream().distinct()
										.sorted(Comparator.comparingInt(Employee::getSalary).reversed()).limit(2)
										.skip(1).findFirst())));

		secondHighestByDept.forEach((department, employeeOptional) -> {
			System.out.println("Department: " + department);
			employeeOptional.ifPresentOrElse(employee -> System.out.println(employee.getName() +" : "+employee.getSalary()), // Using
																										// toString()
					() -> System.out.println("No second highest salary found in this department."));
			System.out.println("--------------------");
		});

		/*
		 * Map<String, Integer> map = new HashMap<>(); map.put("Anil",1200);
		 * map.put("Aman",2500); map.put("Raj",1000); map.put("Vijay",1800);
		 * map.put("Krun",2500); map.put("Gokul",1150); map.put("abc",3500);
		 */

		String str = "akash is a java developer";
		List<Integer> intList = Arrays.asList(34, 5, 52, 55, 21, 24, 77, 98);

		Map<Character, Long> m2 = str.chars().mapToObj(c -> (char) c).filter(c -> c != ' ')
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		m2.forEach((character, count) -> System.out.println(character + ": " + count));

		// Finding the first repeating character
		Character ch = str.chars().mapToObj(c -> (char) c).filter(new HashSet<>()::add).findFirst().orElseThrow(null);
		System.out.println("first repeting character is: " + ch);

		// printing numbers starting with 5
		System.out.println("the sum of the list is: " + intList.stream().mapToInt(i -> i.intValue()).sum());
		List<Integer> result = intList.stream().filter(i -> String.valueOf(i).startsWith("5"))
				.collect(Collectors.toList());
		result.forEach(System.out::println);

		// Getting above output in string
		System.out.println(
				"something" + intList.stream().filter(i -> String.valueOf(i).startsWith("5")).map(String::valueOf) // Convert
				.collect(Collectors.joining(",")));
	}

}
