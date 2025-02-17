package test;

import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Java is a good language";
		HashSet<Character> set =new HashSet<>();
		Map<Character, Long> result = s.chars().mapToObj(ch->(char) ch)
				.filter(ch->ch.equals(" "))
				.collect(Collectors.groupingBy(ch->ch,Collectors.counting()));
		
		result.forEach((character,count)->System.out.println("repeting character:" + character +"count:"+count));

	}

}
