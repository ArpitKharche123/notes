package executors;

import java.util.concurrent.*;

public class UsingExecutorService {
    static void main() {
        try(ExecutorService exe
              //Thread pool will be created with max n number of Thread
//            = Executors.newFixedThreadPool(2);

             //n Threads for n tasks will be created in the pool
//            =Executors.newCachedThreadPool();

             //Only 1 thread will be created
//            =Executors.newSingleThreadExecutor();

            // n virtual threads for n tasks
            = Executors.newVirtualThreadPerTaskExecutor()
        )
        {
            exe.execute(
                    ()->{
                        String name = Thread.currentThread().getName();
                        System.out.println(name+": task1");
                    }
            );

            exe.execute(
                    ()->{
                        String name = Thread.currentThread().getName();
                        System.out.println(name+": task2");
                    }
            );

            exe.execute(
                    ()->{
                        String name = Thread.currentThread().getName();
                        System.out.println(name+": task3");
                    }
            );

            Callable<Integer> c =
                    () -> (int) (Math.random() * 10_000);

            Future<Integer> result = exe.submit(c);

            System.out.println(result.get());

        } catch (ExecutionException | InterruptedException e){
            throw new RuntimeException(e);
        }

    }
}
