package basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Counter{
	static int count = 0;
	
	// Data inconsistency will happen
//	static void increment() {
//		count++;
//	}
	
	//Synchronization
	static synchronized void increment() {
		count++;
	}
	
	static int c1=0;
	static void incre() {
		//Class Lock
		synchronized (Counter.class) {
			c1++;
		}
	}
	
	int c2=0;
	void incre2() {
		//Object Lock
		synchronized (this) {
			c2++;
		}
	}
}
public class DataInconsistency {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		
		service.execute(()->{
			for(int i=0;i<1_00_000;i++) {
				Counter.increment();
			}
		});
		
		service.execute(()->{
			for(int i=0;i<2_00_000;i++) {
				Counter.increment();
			}
		});
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Counter.count);
		
		service.shutdown();
	}
}
