package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String input = "aje521ght684ty";
		//yt684thg521eja
		
		//Getting the number of occurrences of digits from all the 3 lists and reversing it.
		List<Integer> integer1 = Arrays.asList(1,4,6,8,3,6); 
		List<Integer> integer2 = Arrays.asList(1,7,6,9,3,4); 
		List<Integer> integer3 = Arrays.asList(1,5,8,9,2,4);
		
		List<List<Integer>> integer4 = Arrays.asList(integer1, integer2, integer3);
		
		Map<Object, Long> result = integer1.stream().collect(Collectors.groupingBy(in->in, Collectors.counting()));
		result.forEach((num,count)->System.out.println("number:"+num+"conunt"+count));
		
		Map<String, Long> digitCounts = integer4.stream()
                .flatMap(List::stream) // Flatten the list of lists
                .map(String::valueOf)
                //.flatMap(s -> s.chars().mapToObj(c -> String.valueOf((char) c)))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		Map<String, Long> sortedDigitCounts = digitCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())) // Reverse order
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(sortedDigitCounts);
		
        
        //reversing a string where the digits are still the same
		String input = "aje521ght684ty";
		char[] chars = input.toCharArray();
		int j = chars.length - 1;

		for (int i = 0; i < chars.length / 2; i++) {
		    if (Character.isLetter(chars[i]) && Character.isLetter(chars[j])) {
		        char temp = chars[i];
		        chars[i] = chars[j];
		        chars[j] = temp;
		        j--;
		    } else if (!Character.isLetter(chars[i])) {
		        // Skip non-letters from the left
		    } else if (!Character.isLetter(chars[j])) {
		        j--; // Skip non-letters from the right
		    } else {
		        j--;
		    }
		}

		String reversed = new String(chars);
		System.out.println(reversed); // Output: zyx123cba
		
		
		//finding the common elements from both the Lists
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 5, 7, 8, 9);

        
        // Method 1: Using retainAll (modifies list1)
        List<Integer> common1 = new ArrayList<>(list1); // Create a copy to avoid modifying the original
        common1.retainAll(list2);
        System.out.println("Common numbers (retainAll): " + common1); 
        
        
        //Creating an even number list from an Integer stream
        IntStream numbers = IntStream.rangeClosed(1,100);
        List<Integer> result2 = numbers.filter(n->n%2==0).boxed().toList();
        int value1 = numbers.filter(n->n%2==0).sum();//to get the sum of all the even numbers
        System.out.println(result2);

	}

}
