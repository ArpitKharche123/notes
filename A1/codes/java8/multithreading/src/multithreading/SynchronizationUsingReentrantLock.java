package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class Test{
	int count = 0;
	ReentrantLock lock = new ReentrantLock();
	
	void increment() {
		try {
			lock.lock();
			count++;
		} finally {
			lock.unlock();
		}
	}
	void decrement() {
		try {
			lock.lock();//locks the resource
			count--;
		} finally {
			lock.unlock();//unlocks the resource
		}
	}
	
	//Synchronization using AtomicInteger
	
	AtomicInteger count2 = new AtomicInteger();
	
	void incre() {
		count2.incrementAndGet();//increments by 1
	}
	
}
public class SynchronizationUsingReentrantLock {
	public static void main(String[] args) {
		try(ExecutorService exe=
				Executors.newCachedThreadPool()){
		
		Test t=new Test();
		
		//Task 1
		exe.submit(()->
		{
			for(int i=0;i<1000;i++) {
				t.increment();
			}
		}
		);
		
		exe.submit(()->
		{
			for(int i=0;i<1000;i++) {
				t.decrement();
			}
		}
		);
		
		exe.submit(()->{
			for(int i=0;i<1000;i++) {
				t.incre();
			}
		});
		exe.submit(()->{
			for(int i=0;i<1000;i++) {
				t.incre();
			}
		});
		/*
		 * single resource: count2(synchronized)
		 * threads: t1 , t2
		 * 
		 * t1 locks count 2(start->runnable->running)
		 * t2(start->runnable->waiting)
		 * 
		 * t1 increments count2(0) by 1000
		 * [count2=1000]
		 * 
		 * t1 used count2(running->terminated)
		 * count2 will be released/un-locked
		 * 
		 * t2 will lock count2(waiting->runnable->running)
		 * 
		 * t2 increments count2(1000) by 1000
		 * [count2 = 2000]
		 *  
		 * t2 used count2(running->terminated)
		 * count2 will be released/un-locked
		 */
		
		Thread.sleep(500);
		
		//Add one more task such that final output
		//should be 500 everytime
		
		System.out.println(t.count);
		System.out.println("Count 2: "+t.count2);
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Create 2 methods(multiply and divide)
		//use one shared resource
		//use those methods using 2 threads
		//(use method reference)
	}
}
