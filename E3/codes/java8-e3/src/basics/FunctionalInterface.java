package basics;

//Functional Interface
@java.lang.FunctionalInterface //optional
interface I1 {
    //Single Abstract Method(SAM)
    void m1();
}

interface I2 {
    void m2(String value);
}

interface I3 {
    double add(double a, double b);
}

public class FunctionalInterface {
    static void main() {
        //Anonymous Inner Type
        I1 i1 = new I1() {
            @Override
            public void m1() {
                //statements;
            }
        };

        //Lambda Expressions
        // Syntax: () -> {}

        //1. no arg, no return-type

        //If we are having only one statement, {} can be skipped!
        I1 i2 = () -> System.out.println("Lamda Expression");
        i2.m1();

        //2. One arg, no return-type

        // If method is having only one arg, () can be skipped!
        I2 i = a -> {
            String value = a;
            System.out.println("Value: " + value);
        };
        i.m2("J2EE");

        //3. multiple args, some return-type
        I3 i3 = (a, b) -> {
            double sum = a + b;
            return sum;
        };
        i3 = (a, b) -> a + b;

        double sum = i3.add(12, 13);
    }
}
