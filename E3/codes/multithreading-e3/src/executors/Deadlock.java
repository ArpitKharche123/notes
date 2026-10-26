package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Resource{}

public class Deadlock {

    Resource r1 = new Resource();
    Resource r2 = new Resource();

    void task1(){
        synchronized (r1){
            System.out.println("T1 locked R1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (r2){
               System.out.println("T1 locked R2");
           }
        }
    }

    void task2(){
        synchronized (r2){
            System.out.println("T2 locked R2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (r1){
                System.out.println("T2 locked R1");
            }
        }
    }

    //Deadlock Avoidance:
    // Lock the resources in same order
    // T1 -> r1,r2
    // T2 -> r1,r2

    void operation1(){
        synchronized (r1){
            System.out.println("T1 locked R1");
            synchronized (r2){
                System.out.println("T1 locked R2");
            }
        }
    }

    void operation2(){
        synchronized (r1){
            System.out.println("T2 locked R1");
            synchronized (r2){
                System.out.println("T2 locked R2");
            }
        }
    }


    static void main() {
        try(ExecutorService e = Executors.newCachedThreadPool()){
            Deadlock d = new Deadlock();
            e.execute(d::operation1);
            e.execute(d::operation2);
        }
    }
}
