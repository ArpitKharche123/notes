package basics;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.*;

class Student{
    int id;
    String name;
    int age;

    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class BuiltInFunctionalInterfaces {
    static void main() {
        List<Student> students = new ArrayList<>(
                Arrays.asList(
                        new Student(1, 21, "Girish"),
                        new Student(3, 24, "Vishvajeet"),
                        new Student(4, 22, "Suresh"),
                        new Student(2, 26, "Rajendra")
                )
        );

        //1.
        Comparator<Student> ageAscComparator =
                (s1,s2) -> Integer.compare(s1.age,s2.age);

        Comparator<Student> nameDescComparator =
                (s1,s2)-> s2.name.compareTo(s1.name);


        Comparator<Student> idAscComp =Comparator.comparing(s->s.id),
                idDescComp = idAscComp.reversed();

        students.sort(idAscComp);
        students.forEach(System.out::println);

        //2.
        Function<String,Integer> f
                = str -> str.length();
                //String::length;
        System.out.println(f.apply("Laptop"));

        //3.
        UnaryOperator<String> uo = s ->s.toUpperCase();
                                //String::toUpperCase
        System.out.println(uo.apply("qSPiDER"));

        //4.
        BiFunction<String,Integer,String> bi=
                (name,age)->
                        name+ " is "+age+" years old";
        bi.apply("Jack",55);

        //5.
        BinaryOperator<Double> biO=
                (a,b)->a+b;
                // or Double::sum
        biO.apply(10.0,18.0);

        //6.
        Predicate<Integer> isEven = n -> n % 2 == 0;
        isEven.test(8);

        //7.
        BiPredicate<String,String> isEqual
                = (s1,s2) -> s1.equalsIgnoreCase(s2);
                //or
                //String::equalsIgnoreCase

        isEqual.test("PyTHon","PYTHon");

        //8.
        Consumer<Integer> con = i -> System.out.println(i);
                            //System.out::println
        con.accept(12);

        //9.
        BiConsumer<String,Integer> biCon
                = (name,age)
                -> System.out.println(name+" is "+age+" years old!");
        biCon.accept("Raju",23);

        //10.
        Supplier<String> idSupplier =
                () -> UUID.randomUUID().toString();

        System.out.println(idSupplier.get());




    }

}
