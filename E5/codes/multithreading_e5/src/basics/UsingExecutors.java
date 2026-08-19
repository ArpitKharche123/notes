package basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingExecutors {
	public static void main(String[] args) {
		
		ExecutorService service 
		//Only one thread will be created in the pool
		= Executors.newSingleThreadExecutor();
		
		//specified no. of threads will be created
		service = Executors.newFixedThreadPool(2); 
		
		//for n tasks, creates n threads
		service = Executors.newCachedThreadPool();
		
		//Virtual Threads
		//for n tasks, creates n virtual threads
		service = Executors.newVirtualThreadPerTaskExecutor();
		
		service.execute(
				()->{
					String name=Thread.currentThread().getName();
					System.out.println(name+ " is performing the task 1");
				}
				);
		
		service.execute(
				()->{
					String name=Thread.currentThread().getName();
					System.out.println(name+ " is performing the task 2");
				}
				);
		
		service.execute(
				()->{
					String name=Thread.currentThread().getName();
					System.out.println(name+ " is performing the task 3");
				}
				);
		
		service.shutdown();
	}
}
