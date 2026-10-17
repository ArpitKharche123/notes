package basics;

import java.lang.FunctionalInterface;

@FunctionalInterface
interface A{
    void test();
}

class Demo{
    public void nsMethod(){
        System.out.println("Non-static Method");
    }
    public static void staticMethod(){
        System.out.println("Static Method");
    }
}
public class MethodReferences {
    static void main() {
        //Giving new implementation to SAM
        A a = () -> System.out.println("My implementation");

        // Giving existing implementation to SAM
        // Using Method References

        //1.  Giving/Refering impl of n.s. method
        //   ref_var :: method_name
        Demo d = new Demo();
        A a1 = d :: nsMethod;
        a1.test();

        //2. Giving/refering implementation of static method
        // Classname :: method_name

        A a2 = Demo :: staticMethod;
        a2.test();



    }
}
