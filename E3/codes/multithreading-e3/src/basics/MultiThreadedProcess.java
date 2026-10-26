package basics;

public class MultiThreadedProcess {
    static void main() {
        Runnable r = () ->{
            for (int i=1;i<=10_000;i++){
                System.out.print(i);
            }
        };
        //Creating platform threads
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(
                ()->{
                    for (char i=1;i<=10_000;i++){
                        System.out.print(i);
                    }
                }
        );

        t1.start();
        t2.start();
    }
}
