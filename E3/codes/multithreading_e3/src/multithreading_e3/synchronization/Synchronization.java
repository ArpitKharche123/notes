package multithreading_e3.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Counter {
	//Shared resource
	int count = 0;

	//data inconsistency
	/*
	 * When more than one thread try
	 * to access same resource at same time
	 * 
	 * we may get incorrect results
	 */
	void increment() {
		count++;
	}
	
	//Fix: Synchronization
	
	synchronized void increment2() {
		count++;
	}
	
	void incre() {
		//Logic inside this block can be used
		//only by 1 thread at a time
		
		//Object lock
		synchronized (this) {
			count++;
		}
		//Here we can write the logic that
		// we don't want to synchronize
	}
	
	//Static Shared Resource
	
	static int c=0;
	
	void incre2() {
		//Class lock
		synchronized (Counter.class) {
			c++;
		}
	}
}

public class Synchronization {
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();

		try (ExecutorService exe = Executors.newFixedThreadPool(2)) {

			exe.submit(() -> {
				for (int i = 0; i < 10_000; i++) {
					counter.incre2();
				}
			});

			exe.submit(() -> {
				for (int i = 0; i < 10_000; i++) {
					counter.incre2();
				}
			});

			Thread.sleep(100);
			System.out.println("Count: " + counter.c);
		}

	}
}
