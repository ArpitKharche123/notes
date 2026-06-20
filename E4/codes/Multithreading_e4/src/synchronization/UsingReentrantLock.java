package synchronization;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class Demo{
	int count = 0;
	
	ReentrantLock lock = new ReentrantLock();
	
	void increment() {
		lock.lock();
		try {
			count++;
		}finally {
			lock.unlock();
		}
	}
	
	void decrement() {
		lock.lock();
		try {
			count--;
		}finally {
			lock.unlock();
		}
	}
}
public class UsingReentrantLock {
	public static void main(String[] args) {
		try(var exec= Executors.newCachedThreadPool()){
			Demo d = new Demo();
			exec.submit(
					()->{
						for(int i=0;i<10_000;i++) {
							d.increment();
						}
					}
					);
			
			exec.submit(
					()->{
						for(int i=0;i<10_000;i++) {
							d.decrement();
						}
					}
					);
			
			Thread.sleep(500);
			System.out.println("Count: "+d.count);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
