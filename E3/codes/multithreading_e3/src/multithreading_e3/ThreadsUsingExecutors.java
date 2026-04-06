package multithreading_e3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsUsingExecutors {
public static void main(String[] args) {
	ExecutorService executor=
			Executors.newSingleThreadExecutor();
	
	executor.execute(
			()->{
				String name = Thread.currentThread().getName();
				System.out.println(name+" is executing task 1");
			}
			);
	executor.execute(
			()->{
				String name = Thread.currentThread().getName();
				System.out.println(name+" is executing task 2");
			}
			);
	
	executor.shutdown();
	
}
}
