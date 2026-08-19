package basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class Counter2{
	//By-default Synchronized in nature
	AtomicInteger count= new AtomicInteger(0);
	
	void increment() {
		count.incrementAndGet();//increment by 1
	}
	void decrement() {
		count.decrementAndGet();//decrement by 1
	}
	
	//Synchronization using reentrant lock
	
	static int c = 0;
	
	static ReentrantLock lock = new ReentrantLock();
	
	static void incrementC() {
		lock.lock();
		try {
			c++;
		} finally {
			lock.unlock();
		}
	}
	
}
public class Synchronization2 {
	public static void main(String[] args) {
		try(ExecutorService e = Executors.newCachedThreadPool()){	
			Counter2 c = new Counter2();
			e.execute(()->{
				for(int i=0;i<10_000;i++) {
					c.increment();
				}
			});
			e.execute(()->{
				for(int i=0;i<10_000;i++) {
					c.decrement();
				}
			});
			Thread.sleep(500);
			System.out.println(c.count);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
