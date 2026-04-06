package multithreading_e3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
	public static void main(String[] args) {
		ExecutorService executor=Executors.newCachedThreadPool();
		
		executor.execute(()->{
			System.out.println(Thread.currentThread().getName()+
					" is executing task 1");
		});
		executor.execute(()->{
			System.out.println(Thread.currentThread().getName()+
					" is executing task 2");
		});
		executor.execute(()->{
			System.out.println(Thread.currentThread().getName()+
					" is executing task 3");
		});
		
		executor.shutdown();
	}
}
