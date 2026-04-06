package multithreading_e3.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Resource1{
	void use(String rName) {
		System.out.println(rName+" resource is used");
	}
}

public class DeadlockAvoidance {
	
	Resource1 r1=new Resource1();
	Resource1 r2=new Resource1();
	
	ReentrantLock lock=new ReentrantLock();
	
	void task1() {
		try {
			if (lock.tryLock(1, TimeUnit.SECONDS) ) {
				System.out.println("thread 1 acquired the lock");
				r1.use("r1");
				r2.use("r2");
			}
			else {
		System.err.println("thread 1 failed to acquire the lock");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
			System.out.println("thread 1 released the lock");
			System.out.println("---------------------");
		}
	}
	
	void task2() {
		try {
			if (lock.tryLock(1, TimeUnit.SECONDS) ) {
				System.out.println("thread 2 acquired the lock");
				r1.use("r1");
				r2.use("r2");
			}
			else {
				System.err.println("thread 2 failed to acquire the lock");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
			System.out.println("thread 2 released the lock");
			System.out.println("---------------------");
		}
	}
	
	public static void main(String[] args) {
		try(ExecutorService exe=Executors.newCachedThreadPool()){
			DeadlockAvoidance d=new DeadlockAvoidance();
			
			exe.submit(d::task1);
			exe.submit(d::task2);
		}
	}
}
