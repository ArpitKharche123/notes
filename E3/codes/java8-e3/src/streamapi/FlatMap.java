package streamapi;

//1. Person, Address

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Record is a special type of class/compact way of creating a class
/*
    * All properties will be implicitly private final
    * Used to create immutable objects
    * Implicitly creates
    *   all-arg constructor
    *   accessor methods(getters)[name will be same as variables]
    *   toString(), equals() and hashCode()
 */
record Person(
        int id,String name,int age, List<Address> addresses
){ }

record Address(
        String street,String city,String state
){}

public class FlatMap {
    static void main() {
        List<Person> persons =
                new ArrayList<>(
                        Arrays.asList(
                                new Person(
                                        1,"Mohammad",21,
                                        Arrays.asList(
                                                new Address("wakad","pune","maharashtra"),
                                                new Address("basvanagudi","banglore","karnataka"
                                                )

                                        )
                                )
                        )
                );

        persons.stream()
                .flatMap( p -> p.addresses().stream())
                .map(Address::street)
                .forEach(System.out::println);

    }
}
