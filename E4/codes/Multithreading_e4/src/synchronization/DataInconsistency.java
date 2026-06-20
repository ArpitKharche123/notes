package synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Test{
	int count = 0;
	
	// We might get the incorrect result as
	//multiple threads might be accessing the increment()
	//method at a same time
	
//	void increment() {
//		count++;
//	}
	
	//We can fix it using Synchronization
	//Only one Thread can use increment() method at a time
	//Other Threads will wait
	synchronized void increment() {
		count++;
	}
	
	//Class Lock: static shared resource
	static int c2=0;
	
	void increment1() {
		synchronized (Test.class) {
			c2++;
		}
		System.out.println(c2);
	}
	
	//Object Lock: non-static shared resource
	int c3 = 0;
	
	void increment2() {
		synchronized (this) {
			c3++;
		}
	}
}
public class DataInconsistency {
	public static void main(String[] args) {
		try(ExecutorService exec = 
				Executors.newVirtualThreadPerTaskExecutor()){
			
			Test t=new Test();
			exec.submit(
					()->{
					for(int i=0;i<10_000;i++) {
						t.increment();
					}
					}
					);
			exec.submit(
					()->{
					for(int i=0;i<10_000;i++) {
						t.increment();
					}
					}
					);
			
			Thread.sleep(500);
			System.out.println("Count: "+t.count);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
