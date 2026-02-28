package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Synchronization {
	
	int count = 0;
	static int c2 = 0;

	//count will be incremented incorrectly
	//i.e multiple threads can change count
	//at same time!!!
	
	//data inconsistency will happen here
	
	void increment1() {
		count++;
	}
	
	//Fix:
	//Here, increment() can be used by only 1 Thread 
	//at a time, other Threads will wait !
	synchronized void increment() {
			count++;
	}
	
	void incre() {
		//This will lock the non-static variable count
		synchronized (this) {
			count++;
		}
		//Here we can write other logics
		//which we dont want to synchronize
		
		//This will lock the static variable c2 
		synchronized (Synchronization.class) {
			c2++;
		}
	}
	
	public static void main(String[] args) {
		try (ExecutorService e =
				Executors.newFixedThreadPool(2)) {

			Synchronization s = new Synchronization();

			//Incrementing count by 1000
			 Runnable r = () -> {
				for (int i = 0; i < 1000; i++) {
					s.increment();
				}
			};
			
			e.submit(r);//thread 1 will perform this task
			e.submit(r);//thread 2 will perform this task
			
			Thread.sleep(500);
			System.out.println(s.count);
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
