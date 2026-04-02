package java_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class StreamApi {
	public static void main(String[] args) {
		List<Integer> list
		=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		//Collecting even numbers in another list
		List<Integer> evenList=new ArrayList<>();
		for(int a:list) {
			if (a%2==0) {
				evenList.add(a);
			}
		}
		
		//Using Stream API
		List<Integer> l2 = 
		list.stream()//creates a stream
		.filter(n->n%2==0)//filters even numbers 
		.toList();//converts stream to list
		
		//l2.forEach(System.out::println);
		
		//Performing multiple operation
		list.stream()
		.map(n->n*10)//transforming the elements
		.filter(n->n>40)
		.forEach(System.out::println);
		
		System.out.println("-------------------");
		
		Arrays.asList(1,4,3,2,5)
		.stream()
		//.sorted() //sort in ascending order
		.sorted((n1,n2)->n2-n1) //descending order
		.forEach(System.out::println);
		
		long count = list.stream()
		.filter(n->n<5)
		.count();//count no. of elements in stream
		
		System.out.println("Count: "+count);
		
		Arrays.asList(1,2,1,4,3,4,5,6,5)
		.stream()
		.distinct()//removes repeated elements
		.forEach(System.out::println);
		
		System.out.println("--------------");
		
		list.stream()
		//.limit(5)  //it will consider only first n elements
		.skip(5)  //it will skip first n elements
		.forEach(System.out::println);
		
		List<Integer> lenghts 
		= Arrays.asList("Ajit","Rakesh","Gargi","Mahima")
		.stream()
		.map(s->s.length())
		//length of each string is considered
		.toList();//it will return immutable list
		
		lenghts.forEach(System.out::println);
		
		//lenghts.add(0);
		//UnsupportedOperationException
		
		List<Integer> l = list.stream()
		.filter(n->n%2==1)
		.collect(Collectors.toList());
		//mutable/modifiable list
		
		l.add(101);//This will be allowed
		
		//Converting List to LinkedList
		LinkedList<Integer> ll 
		= list.stream()
		.collect(Collectors
				.toCollection(LinkedList::new));
		
		//Converting List to Set
		Set<Integer> set 
		= list.stream()
		.collect(Collectors.toSet());
		
		String str 
		= Arrays.asList("Hello","Guys","how","are","you")
		.stream()
		.collect(Collectors.joining(" "));
		
		System.out.println(str);
		
		System.out.println("--------------------------");
		//List to Map
		Arrays.asList("Alex","Carl","Smith","Martin")
		.stream()
		.collect(Collectors.toMap(
				s-> UUID.randomUUID(),
				s->s)
				)
		.forEach((k,v)->System.out.println(k+":"+v));
		/*
		 * task: take one list of type String
		 * for each String, map the sum of each
		 * characters(ASCII values) as its key
		 */
		
		Map<Boolean, List<Integer>> evenOddGroup 
		= Arrays.asList(1,2,3,4,5,6,7,8)
		.stream()
		.collect(Collectors.partitioningBy(
				n->n%2==0
				));
		
		evenOddGroup.forEach((k,v)->
		System.out.println(k + "=" + v));
		//h.w: print values in different lines
		
		Map<String, List<Integer>> m2 
		= Arrays.asList(1,-2,4,-3,5,-8,10,-7)
		.stream()
		.collect(Collectors.groupingBy(
			n->{
				if (n%2==0) {
					return (n>0)
							?"Positive Even"
							:"Negative Even";
				}
				else {
					return (n>0)
							?"Positive Odd"
							:"Negative Odd";
				}
			}
		));
		
		m2.forEach((k,v)->
		System.out.println(k+"->"+v));
		
		//Sum of all elements
		Integer sum = list.stream()
		.reduce(0, (n1,n2)->n1+n2);
		
		System.out.println(sum);
		
		//Product of all elements
		Integer prod = list.stream()
		.reduce(1,(n1,n2)->n1*n2);
		
		System.out.println(prod);
		
		int max= list.stream()
		.reduce(Integer.MIN_VALUE,Integer::max);
		//or
		
		max=list.stream()
			.reduce(Integer::max)
			.get();
		
		//or
		
		max =list.stream()
				.max(Integer::compareTo)
				.get();
		
		System.out.println(max);
		
		int min=list.stream()
		.reduce(Integer.MAX_VALUE,Integer::min);
		//or
		
		min= list.stream()
				.reduce(Integer::min)
				.get();
		//or
		
		min =list.stream()
				.min(Integer::compareTo)
				.get();
		
		System.out.println(min);
	}
}
