package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsUsingExecutors {
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// Creating a Single Thread
//		try(ExecutorService executor= 
//				Executors.newSingleThreadExecutor()) {
//
//			//Passing the logic as well as 
//			//starting the thread
//			executor.submit(
//			()->{
//				//Setting the Thread Name
//				Thread.currentThread().setName("Thread 1");
//				for(int i=0;i<5;i++) {
//					//Fetching the Thread Name
//					System.out.println(
//					Thread.currentThread().getName()
//					+" is executing task 1");
//				}
//			}
//			);
//			executor.submit(
//					()->{
//						for(int i=0;i<5;i++) {
//							System.out.println(
//							Thread.currentThread().getName()
//							+" is executing task 2");
//						}
//					}
//				);
//		}

		// Creating Thread Pool

//				try (ExecutorService e =
//						// Only 2 Threads will be created at max
//						
//						Executors.newFixedThreadPool(2)) {
//
//					Runnable r = () -> {
//						for (int i = 0; i < 5; i++) {
//							System.out.println(Thread.currentThread().getName() + " is running");
//						}
//					};
//					// Each task will be executed by either
//					//one of the two threads, so 3rd task will 
//					//wait for some time
//					e.submit(r);
//					e.submit(r);
//					e.submit(r);

		// Cached Thread Pool
		try (ExecutorService e =
				// New Threads will be created as per
				// need
				Executors.newCachedThreadPool()) {

			Runnable r = () -> {
				for (int i = 0; i < 5; i++) {
					System.out.println(Thread.currentThread().getName() + " is running");
				}
			};
			// Each task will be executed by a separate
			// thread
//			e.submit(r);
//			e.submit(r);
//			e.submit(r);
			
			//Virtual Threads
			try(ExecutorService exec=
				Executors.newVirtualThreadPerTaskExecutor()){
				
				//We can only pass Runnable to execute()
				exec.execute(()->{
					System.out.println("Task 1");
				});

				//We can pass both Runnable as well as
				//Callable to submit()
				exec.submit(()->{
					System.out.println("Task 2");
				});
				
				Callable<Double> random=()->{
					return Math.random();
				};
				
				Double randomNum = exec.submit(random).get();
				System.out.println(randomNum);
			}

			
		}

	}
}
