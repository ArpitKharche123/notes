package basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Resource1 {
	void use(String tName, String resourceName) {
		System.out.println(tName + " is using " + resourceName);
	}
}
public class DeadLockAvoidance {

	Resource1 r1 = new Resource1();
	Resource1 r2 = new Resource1();
	ReentrantLock lock = new ReentrantLock();

	// Thread 1 will execute this:
	void task1() {
		try {
			if(lock.tryLock(1, TimeUnit.SECONDS)) {
				System.out.println("Thread 1 acquired the lock");
				r1.use("Thread 1", "Resource 1");
				r2.use("Thread 1", "Resource 2");
			}else {
				System.err.println("Thread 1 failed to acquire the lock");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
			System.out.println("Thread 1 released the lock");
		}
	}

	// Thread 2 will execute this:
	void task2() {
		try {
			if(lock.tryLock(1, TimeUnit.SECONDS)) {
				System.out.println("Thread 2 acquired the lock");
				r1.use("Thread 2", "Resource 1");
				r2.use("Thread 2", "Resource 2");
			}else {
				System.err.println("Thread 2 failed to acquire the lock");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
			System.out.println("Thread 2 released the lock");
		}
	}

	public static void main(String[] args) {
		try(ExecutorService e = Executors.newCachedThreadPool()){
			
			DeadLockAvoidance d = new DeadLockAvoidance();
			e.execute(d::task1);
			e.execute(d::task2);
		}
	}
}
