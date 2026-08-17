package java8_e5.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.UUID;
import java.util.stream.Collectors;

public class StreamApi {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8);
		
		List<Integer> evenList = new ArrayList<Integer>();
		
		for(int i:nums) {
			if(i%2==0) {
				evenList.add(i);
			}
		}
		evenList.forEach(System.out::println);
		
		//Using Stream Api
		//stream pipeline
		nums.stream()// stream(source)
		.filter(n -> n % 2 == 0) //intermidiate operation
		.toList() //terminal operation
		.forEach(System.out::println);
		
		//Create a stream
		List<Integer> a = Arrays.asList(-1,0,2,-3,4,5,-6)
		.stream()
		//considering only positive numbers
		.filter(n->n>0) // 2,4,5
		//transforming numbers to their squares
		.map(n->n*n) //4,16,25
		.toList(); //converts Stream into immutable list
		
		List<Integer> list = Arrays.asList(9,1,3,8,9,1,2,3,4,5);
		System.out.println("-------------------------------------------");
		
		
		Integer integer = list.stream()
		.distinct() //remove duplicate elements
		.sorted()
		.sorted( (n1,n2)->n2-n1 )//desc
		.limit(4) //considers first n elements
		.skip(1) // skips first n elements
		.findFirst() //return first element
		.get();
		
		System.out.println(integer);
		
		//Returns true if any one of the element
		//satisfies the Predicate condition
		boolean b1 = nums.stream()
		.anyMatch( n -> n>7);//true
		
		//Returns true if all the elements
		//satisfies the Predicate condition
		boolean b2 = nums.stream()
		.allMatch( n -> n<=8);//true
		
		Integer sum =
				nums.stream()
		            .reduce(0, (n1,n2)->n1+n2);
		
		System.out.println("Sum: "+sum);
		
		Integer prod =
				nums.stream()
		            .reduce(1,
		            		(n1,n2)->n1*n2);
		
		Integer max = nums.stream()
		.reduce(Integer::max)
		.get();
		
		System.out.println(max);
		
		Integer min = nums.stream()
				.reduce(Integer::min)
				.get();
		
		List<Integer> l = nums.stream()
		.toList();//immuatable list
		
		//l.add(9);//UnsupportedOperationException
		
		//Converting Stream into Mutable List
		List<Integer> l2 
		 = nums.stream()
		.collect(Collectors.toList());
		
		l2.add(9);
		
		//List -> Set
		Set<Integer> set 
		= nums.stream()
		.collect(Collectors.toSet());
		
		//List -> Map
		
		Map<String, Integer> map = nums.stream()
		.collect(Collectors.toMap(
				n -> UUID.randomUUID().toString(),
				n-> n)
				);
		
		map.forEach((k,v)->System.out.println(k+" : "+ v) );
		
		System.out.println("-----------------------------------");
		List<Integer> list2 = Arrays.asList(-3,-2,-1,0,1,2,3);
		
		Map<Boolean, List<Integer>> map1 
		= list2.stream()
		.collect(Collectors.partitioningBy(
				n -> n%2 == 0)
				);
		
		map1.forEach((k,v)->System.out.println(k+" : "+ v) );
		
		
		Map<String, List<Integer>> map2 
		= list2.stream()
			 .collect(
				 Collectors.groupingBy(
					 n ->{
						 boolean isEven = n%2==0;
						 if(n>0) {
							 return isEven?"Positive Even":"Positive Odd";
						 }else if(n==0) {
							 return "Zero";
						 }else {
							 return isEven?"Negative Even":"Negative Odd";
						 }
					 }
					 )
					 );
		map2.forEach((k,v)->System.out.println(k+" : "+ v) );

		
		
	}
}
