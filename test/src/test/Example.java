package test;

import java.util.Map;
import java.util.stream.Collectors;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "AAAAABBCCCABC";
		Map<Object, Long> result = input.chars().mapToObj(character -> (char) character)
				.collect(Collectors.groupingBy(character -> character, Collectors.counting()));
		
		result.forEach((charac, count) -> System.out.println(count+charac.toString()));

//output: 5A2B3C1A1B1C

	}
}
