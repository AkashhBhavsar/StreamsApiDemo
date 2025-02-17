package test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Character> character = Arrays.asList('a','k','a','s','h');
		
		character.stream().filter(ch->!ch.equals("k") || !ch.equals("h")).collect(Collectors.toList());
		character.forEach(System.out::println);

	}

}
