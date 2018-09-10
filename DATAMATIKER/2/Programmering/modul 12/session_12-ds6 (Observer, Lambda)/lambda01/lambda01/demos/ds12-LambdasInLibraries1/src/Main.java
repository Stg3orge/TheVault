import java.util.stream.*;
import java.util.*;
import java.util.function.Consumer;

import static java.util.stream.Collectors.toList;

public class Main {

	public static void main(String[] args) {
        
		// Filtering unique elements
        List<Integer> numbers = Arrays.asList(1, 50, 5, 2, 1, 3,
        							21, 23, 7, 5, 3, 2, 4);
        System.out.println("Any between 5 and 10? " +
        		numbers
        			.stream()
        			.anyMatch((x) -> 5<=x && x <= 10));

        
        System.out.println("Filtering evens: ");
        numbers.stream()
        	.filter((x) -> x % 2 == 0)
        	.forEach(x -> System.out.println(x));
        
        System.out.println("Filtering odds and getting them as a list: ");
        List<Integer> l = numbers
        	.stream()
        	.filter((x) -> x % 2 != 0)
        	.collect(toList());
        for(int x : l) System.out.println(x);

        //Summing using reduce:
        int sum = numbers
        			.stream()
        			.reduce(0, (a,b) -> a+b);   
        System.out.println("Summing using reduce: " + sum);
        
        //Counting evens using map-reduce:
        int evenCount = numbers.stream()
        				.map((x) -> { if(x % 2 == 0) 
        								return 1;
        				  			  else 
        				  				return 0;})
        				.reduce(0, (a,b) -> a+b);
        System.out.println("Counting evens using map-reduce: " + evenCount);

               
        // Collecting evens 
        List<Integer> evenList = numbers.stream()
				.filter( x -> x % 2 == 0)
		        .collect(Collectors.toList());
        System.out.println("Collected evens: " + evenList);

        
        // Closures and collecting
        // What is interesting here is that we created res outside the lambda,
        // but modified its *contents* inside the lambda. That is OK.
        // This is not the way to collect, but shows that an outside variable can be used inside 
        // a lambda, if the variable itself doesn't change 
        final List<Integer> res = new ArrayList<>();
        numbers.stream().forEach((x) -> {if(x%5==0) {res.add(x);}});
        System.out.println("Collected 5-divisibles: " + res.toString());
        
        // ... as opposed to the below commented-out code, which doesn't compile.
        /*
        List<Integer> res1 = new ArrayList<>();
        Consumer<Integer> consumer = (x) -> {if(x%5==0) {res1.add(x);}};
        res1 = new ArrayList<>(); // this is the offending line
        numbers.stream().forEach(consumer);
        System.out.println("Collected 5-divisibles: " + res1.toString());
         */
        
        
	}
}

