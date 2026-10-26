package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class Counter{
    static int count = 0;

    //Data inconsistency might occur here:

//    static void increment(){
//        for(int i=0;i<10_000;i++){
//            count++;
//        }
//    }

    //Synchronization:
    // It is a technique where multiple threads can access
    // a shared resource in a certain order/ one after another

    static synchronized void increment(){
        for(int i=0;i<10_000;i++){
            count++;
        }
    }

    static void increment1(){
        //Class lock
        synchronized(Counter.class){
            for(int i=0;i<10_000;i++){
                count++;
            }
        }
    }

    int c = 0;
    void increment2(){
        //Object lock
        synchronized (this){
            for(int i=0;i<10_000;i++){
                c++;
            }
        }
    }

    //It is synchronized in nature by default
    AtomicInteger integer = new AtomicInteger(0);

    void plus(){
        for (int i = 0; i<1000;i++){
            integer.incrementAndGet();
        }
    }
    void minus(){
        for (int i = 0; i<1000;i++){
            integer.decrementAndGet();
        }
    }

    //Using Reentrant lock
    int count2 = 0;
    ReentrantLock l = new ReentrantLock();
    void incre(){
            try {
                //Acquiring a lock
                l.lock();
                for(int i = 0 ; i<1000;i++){
                   count2++;
                }
            }finally {
                l.unlock();
            }
    }

}

public class Syncronization {
    static void main() {
        try(ExecutorService e = Executors.newCachedThreadPool()){

            Counter c = new Counter();

            e.execute(c::increment2);//pool-1-thread-1
            e.execute(c::increment2);//pool-1-thread-2

            Thread.sleep(2000);
            System.out.println("Count: "+c.c);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
