package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Resource1{
    void use(String tName,String resource){
        System.out.println(tName+ " is using "+resource);
    }
}

class Task{
    Resource1 r1 = new Resource1();
    Resource1 r2 = new Resource1();

    ReentrantLock lock = new ReentrantLock();

void task1(){
   try{
       //Acquires a shared lock if not acquired by other thread
       //If lock is acquired by other thread, it will wait for
       //the specified time for the lock to be released, else
       //it will not acquire the lock(Will be terminated)
       if(lock.tryLock(1, TimeUnit.SECONDS)){
           System.out.println("Thread 1 acquired the lock");
           r1.use("Thread1","R1");
           r2.use("Thread1","R2");
       }else {
     System.err.println("Thread 1 failed to acquire the lock");
       }
   } catch (InterruptedException e) {
       throw new RuntimeException(e);
   } finally {
       lock.unlock();
       System.out.println("Thread 1 released the lock");
       System.out.println("--------------------------------");
   }
}
void task2(){
    try{
        if(lock.tryLock(1, TimeUnit.SECONDS)){
            System.out.println("Thread 2 acquired the lock");
            r1.use("Thread2","R1");
            r2.use("Thread2","R2");
        }else {
       System.err.println("Thread 2 failed to acquire the lock");
        }
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    } finally {
        lock.unlock();
        System.out.println("Thread 2 released the lock");
        System.out.println("--------------------------------");
    }
}
}

public class MultipleSharedResources {
    static void main() {
        try(ExecutorService e = Executors.newCachedThreadPool()){
           Task t = new Task();
            e.execute(t::task1);
            e.execute(t::task2);
        }
    }
}
