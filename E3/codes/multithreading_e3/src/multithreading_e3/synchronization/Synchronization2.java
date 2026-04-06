package multithreading_e3.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class Count{
	
	AtomicInteger count=new AtomicInteger();
	
	int c=0;
	
	ReentrantLock lock=new ReentrantLock();
	
	void incre() {
		lock.lock();//it will lock the resource
		try {
			//using the resource
			c++;
			
		}finally {
			lock.unlock();//release the lock after usage
		}
	}
	
	void increment() {
		count.incrementAndGet();
	}
	
	void decrement() {
		count.decrementAndGet();
	}
}

public class Synchronization2 {
	public static void main(String[] args) {
		
		Count c=new Count();
		
		try (ExecutorService exe = 
				Executors.newFixedThreadPool(2)) {
			
			exe.submit(()->{
				for(int i=0;i<1_00_000;i++) {
					c.incre();
				}
			});
			exe.submit(()->{
				for(int i=0;i<1_00_000;i++) {
					c.incre();
				}
			});
			
			Thread.sleep(100);
			System.out.println("Count: "+c.c);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
