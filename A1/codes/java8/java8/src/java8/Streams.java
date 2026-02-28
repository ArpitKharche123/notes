package java8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {
	public static void main(String[] args) {
		//@formatter:off
		List<Integer> list
		= List.of(1,4,2,3,5,6,7,8,10,9);
		
		//Creating a Stream
		list.stream();
		
		//Filtering(even numbers)
		list.stream()
		.filter(num -> num%2==0)
		.forEach(num->System.out.print(num+" "));
		
		//Transforming
		list.stream()
		.map(n->n*n)//num to its square
		.forEach(System.out::println);
		
		//Filtering + transforming
		list.stream()
		.filter(n -> n%2 == 1)//odd nums
		.map(n->n*n*n)//num to cube
		.forEach(System.out::println);
		
		//Printing first 3 elements of the List
		list.stream()
		.limit(3)
		.forEach(n->System.out.print(n+" "));
		
		System.out.println("\n--------------------------");
		
		//Skip first 5 elements of the List
		list.stream()
		.skip(5)
		.forEach(n->System.out.print(n+" "));
		
		System.out.println("\n--------------------------");

		//Sorting (Ascending)
		list.stream()
		.sorted()
		.forEach(n->System.out.print(n+" "));
		
		System.out.println("\n--------------------------");

		//Sorting (Descending)
		list.stream()
		.sorted((n1,n2)->n2-n1)
		.forEach(n->System.out.print(n+" "));
		
		System.out.println("\n--------------------------");

		//Storing in descending order
		List<Integer> descList 
		= list.stream()
		.sorted((n1,n2)->n2-n1)
		.toList();//converts stream into an
		//immutable list
		
		//descList.add(12);
		//Throws UnsupportedOperationException
		
		//Converting stream into mutable list
		List<Integer> list2 =
		list.stream()
		.sorted()
		.collect(Collectors.toList());
		
		list2.add(12);
		
		System.out.println(list2);
		
		List<Integer> nums= List.of(1,2,3,4,5);
		
		//List into ArrayList
		ArrayList<Integer> arrList 
		= nums.stream()
		.collect(
		Collectors.toCollection(ArrayList::new));
		
		//List into LinkedList
		LinkedList<Integer> linkedList 
		= nums.stream()
		.collect(
		Collectors.toCollection(LinkedList::new));
		
		//Remove duplicates from the List
		//List to Set
		
		List.of(1,2,3,2,4,6,5,4,6)
		.stream()
		.collect(Collectors.toSet())
		.forEach(System.out::println);
		
		//List to Map
		nums.stream()
		.collect(Collectors.toMap(
				n->n,
				n->n*10)
				)
		.forEach((key,value)->
		   System.out.println(key+" : "+value)
		   );
		
		//List->Set->Map
		List.of(1,2,3,5,4,3,5,6)
		.stream()//List to stream
		.distinct()
		.collect(Collectors.toMap(//stream to Map
				n->n,
				n->n*n)
				)
		.forEach((k,v)->
		System.out.println(k+"->"+v));
		
		//Distinct elements
		List.of(1,2,3,2,1,4,5,4)
		.stream()
		.distinct()//duplicates are ignored
		.forEach(System.out::println);
		
		//List elements in reversed order
		nums.stream()
		.filter(n->n>=4)
		.toList()
		.reversed()
		.forEach(System.out::println);
		
		System.out.println("-----------------------------");
		//Counting elements in the stream
		long count = nums.stream()
		.filter(n->n>=3)
		.count();
		
		System.out.println(count);
		
		//Joining List of Strings
		String str = List.of("Hello","Everyone",
				"How","are","you")
		.stream()
		.collect(Collectors.joining(" "));
		
		System.out.println(str);
		
		//Find product of all elements 
		//in the list
		Integer product = nums.stream()
		.reduce(1,(a,b)->a*b);
		
		System.out.println("Product: "+product);
		
		//Find sum of all elements 
		//in the list
		Integer sum = nums.stream()
		.reduce(0,(a,b)->a+b);
				
		System.out.println("Sum:"+sum);
		
		//Min in List
		Integer min = nums.stream()
		.reduce(Integer.MAX_VALUE,Integer::min);
		//or
		
		min = nums.stream()
		.min(Integer::compareTo)
		.get();
		
		System.out.println("Min: "+min);
		
		Integer max = nums.stream()
		.reduce(Integer.MIN_VALUE,Integer::max);
		
		//or
		
		max= nums.stream()
		.max(Integer::compareTo)
		.get();
		
		System.out.println("Max: "+max);
		
		//Grouping the elements
		Map<String, List<Integer>> map 
		= List.of(1,3,-8,-7,2,9,-9,-10,4)
		.stream()
		.collect(Collectors.groupingBy(
				n->{
				if (n<0) {
					return n%2==0?
							"Negative Even":
							"Negative Odd";
				}else {
					return n%2==0?
							"Positive Even":
							"Positive Odd";
				}
				}
				));
		map.forEach((k,v)->
		System.out.println(k+":"+v));
		
		//Partioning
		Map<Boolean, List<Integer>> isNegative 
		= List.of(1,3,-8,-7,2,9,-9,-10,4)
		.stream()
		.collect(Collectors.partitioningBy(
				n->n<0
				));
		
		isNegative.forEach((key,value)->
		System.out.println(key+"->"+value));
		
		
	}
}
