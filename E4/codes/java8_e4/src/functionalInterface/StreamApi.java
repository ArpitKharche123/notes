package functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.UUID;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {
	public static void main(String[] args) {
		//Extract even digits from a list and store it in another list
		List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
		
		List<Integer> evenList = new ArrayList<Integer>();
		
		for(int i : list) {
			if (i%2==0) {
				evenList.add(i);
			}
		}
		//Using stream api
		List<Integer> evenList2 =
		list.stream()
			.filter( n -> n%2==0)
			.toList();//converts stream into immutable list
		
		//Creating a stream pipeline
		Arrays.asList(1,2,3,4,5,6)
				.stream()//source
				.filter(n -> n%2!=0)//intermidiate operation
				.forEach(System.out::println);//terminal operation
		
		Arrays.asList("Rohan","Michael","Jack","Om","Karan")
			.stream()
			//map() is used to transform the stream elements
			//here we are transforming string into its length
			.map(s->s.length())//5,7,4,2,5
			.forEach(System.out::println);
		
		List<Integer> pows = list.stream()
								.map(n->n*n)
								.toList();//immutable
		
		//pows.add(121); //UnsupportedOperationException
		
		//Converting stream into Mutable List
		List<Integer> p = pows.stream()
		    .collect(Collectors.toList());
		
		p.add(121);
		
		p.stream().forEach(System.out::println);
		
		System.out.println("-----------------------------");
		
		//We can perform multiple operations on a single stream
		list.stream()          //1,2,3,4,5,6,7,8,9,10
			.filter(n-> n>5)   // 6,7,8,9,10
			.map(num->num*10) // 60,70,80,90,100
			.sorted() //sorted in ascending order
			.sorted(Comparator.reverseOrder())// 100,90,80,70,60
			.limit(3)   //100,90,80
			.skip(2)    //80
			.forEach(System.out::println);
		
		long count = Arrays.asList(1,2,1,4,3,3,5,4)
			  .stream()
			  .distinct()
			  .count();
		
		System.out.println(count);
		
		Integer sum = list.stream()
			.reduce(0, (n1,n2)->n1+n2);
		
		
		System.out.println("Sum: "+sum);
		
		int prod = list.stream()
					.reduce(1, (a,b)->a*b);
		
		System.out.println("Product: "+prod);
		
		Integer max = list.stream()
			.reduce(Integer::max)
			.get();
		//or
		max = list.stream()
				.max(Integer::compareTo)
				.get();

		System.out.println("Max: "+max);
		
		Integer min = list.stream()
				.reduce(Integer::min)
				.get();
		//or
		
		min = list.stream()
				.min(Integer::compareTo)
				.get();
			
			System.out.println("Min: "+min);
		
		String str = Arrays.asList("Good","Night","Bye","bye!!")
			  .stream()
			  .collect(Collectors.joining("\n"));
		
		System.out.println(str);
		System.out.println("----------------------------------");
		//List to Stack
		Stack<Integer> stack = list.stream()
			.collect(
				Collectors.toCollection(Stack::new));
		
		//List to Set
		Arrays.asList(1,2,1,4,3,4,5,3)
			.stream()
			.collect(Collectors.toSet())
			.forEach(System.out::println);
		
		System.out.println("------------------------------------");
		
		//List to Map
		list.stream()
			.collect(Collectors.toMap(
					n->UUID.randomUUID()
							.toString()
							.substring(0, 8), //keys
					n->n) //values
					)
			.forEach((k,v)->System.out.println(k+"->"+v));
		
		//Creating groups of elements in stream
		
		//Creating 2 groups(true and false)
		Map<Boolean, List<Integer>> grp 
			= Arrays.asList(-3,-2,-1,0,1,2,3)
			  .stream()
			  .collect(Collectors.partitioningBy( n->n%2==0 ));
		
		grp.forEach((k,v)->System.out.println(k+":"+v));
		
		//Creating multiple groups
		 Arrays.asList(-4,-3,-2,-1,0,1,2,3,4)
		 	.stream()
		 	.collect(Collectors.groupingBy(
		 			n->{
		 				if (n>0) {
							return (n%2==0)
									?"Positive Even"
									:"Positive Odd";
						}else if(n==0) {
							return "Zero";
						}else {
							return (n%2==0)
									?"Negative Even"
									:"Negative Odd";
						}
		 			}
		 			))
		 	.forEach((k,v)->System.out.println(k+"="+v));
		 	
		
		
		
		
	}
}
