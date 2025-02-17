package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Write a stream one liner program to find out dept having most no of employees
		
		List<Employee> emp = new ArrayList<>();
		
		emp.add(new Employee(1, "AKash", 10000, "IT"));
		emp.add(new Employee(2, "AKash", 10000, "HR"));
		emp.add(new Employee(3, "AKash", 10000, "HR"));
		emp.add(new Employee(4, "AKash", 10000, "IT"));
		emp.add(new Employee(5, "AKash", 10000, "HR"));
		
		Optional<String> dpet = emp.stream()
				.collect(Collectors.groupingBy(employee->employee.getDept(), Collectors.counting()))
				.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
		
		System.out.println(dpet);
		//dpet.forEach((dept,count)->System.out.println("dept"+dept+"count"+count));
		
		//Write a function that generates all permutations of a string. The result should not contain duplicates.
		String input = "ABC";
		
		input.chars().mapToObj(ch->(char) ch).collect(Collectors.toList());
		
		
		//write on functional interface and write its implementation using the lamba expression and call it
		
		FunctionalDemo f = (int a, int b)->a+b;
		int result = f.sum(5, 6);
		System.out.println(result);
	}

}
