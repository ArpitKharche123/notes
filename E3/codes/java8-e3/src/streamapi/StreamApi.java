package streamapi;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApi {
    static void main() {
        List<Integer> nums
                = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //Filtering even numbers from the list
        List<Integer> evenNums = new ArrayList<>();
        for(int a:nums){
            if(a%2==0)
                evenNums.add(a);
        }

        //Using Stream api
        //Stream Pipeline
        nums.stream()    // source
            .filter(n -> n%2==0) //intermediate operation
            .forEach(System.out::println);// terminal operation

        List<Integer> l = nums.stream()
                .filter(n -> n > 5)//filtering numbers >5
                .map(n -> n * n)//transforming nums-> squares
                .toList();//Stream to Immutable List

        l.forEach(System.out::println);

        long count = nums.stream()
                .sorted() //sorts in asc order
                .sorted(Comparator.reverseOrder()) //desc
                .distinct() //ignore the duplicates
                .count();
        System.out.println("Count: "+count);


        Arrays.asList(10,20,30,40,50)
                .stream()
                //Only considers first n elements
                .limit(3)  //10,20,30
                //Skips first n elements
                .skip(2) //30
                .forEach(System.out::println);


        Integer i = nums.stream()
                  .findFirst()//considers first element of stream
                  .get();

        boolean all = nums.stream()
                //return true if all elements satisfies the
                // given Predicate condition
                .allMatch(n -> n > 9);

        nums.stream()
                //return true if any one element satisfies the
                // given Predicate condition
                .anyMatch(n->n>9);

        Integer max = nums.stream()
                //performs reduction operation, and reduces
                //stream to single result
                .reduce(Integer::max)
                .get();

        System.out.println("Max: "+max);

        nums.stream()
                .max(Integer::compareTo);

        Integer sum = nums.stream()
                .reduce(0, (a, b) -> a + b);

        //Immutable to mutable List
        List<Integer> list2 = nums.stream()
                .collect(Collectors.toList());
        list2.add(11);


        //List to Set
        Set<Integer> set = nums.stream()
                .collect(Collectors.toSet());

        // List to Map
        Map<String, Integer> map = nums.stream()
                .collect(Collectors.toMap(
                        a -> UUID.randomUUID()
                                .toString()
                                .substring(0, 7)
                        , n -> n

                ));

        map.forEach((k,v)
                -> System.out.println(k+" : "+v));

        //Grouping the collection
        List<Integer> integers = Arrays.asList(-4, -3, -2, -1, 0, 1, 2, 3, 4);

        Map<Boolean, List<Integer>> m1 =
                integers
                .stream()
                .collect(Collectors.partitioningBy(
                        n -> n % 2 != 0
                ));

        m1.forEach((k,v) ->
                System.out.println(k+" => "+v)
        );

//Creating multiple groups:
        Map<String, List<Integer>> m2
                = integers.stream()
                .collect(Collectors.groupingBy(
                        num -> {
//                            return (num==0)?"Zero"
//                                    :(num>0)
//                                    ?(num%2==0)
//                                    ?"Positive Even":"Positive Odd"
//                                    :(num%2==0)
//                                    ?"Negative Even":"Negative Odd";
                            //or

                            if (num == 0) {
                                return "Zero";
                            } else if (num > 0) {
                                if (num % 2 == 0) {
                                    return "Positive Even";
                                } else {
                                    return "Positive Odd";
                                }
                            } else {
                                if (num % 2 == 0) {
                                    return "Negative Even";
                                } else {
                                    return "Negative Odd";
                                }
                            }
                        }
                ));
        m2.forEach((key,value)->
                        System.out.println(key+" <--> "+value));
    }
}
