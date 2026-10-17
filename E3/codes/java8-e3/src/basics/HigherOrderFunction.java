package basics;

import java.lang.FunctionalInterface;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface FI{
    void test();
}
class Test{
    //higher order function (hof)
    // hof is a method which either accepts or returns
    // functional interface type
    public static void hof(FI i){
        i.test();
    }
}

public class HigherOrderFunction {
    static void main() {
        FI i1 = ()-> System.out.println("Hello");

        Test.hof(i1);
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        //In-built higher order function
        list.forEach(
                e -> System.out.println(e)
        );

        list.forEach(System.out::println);
    }
}
