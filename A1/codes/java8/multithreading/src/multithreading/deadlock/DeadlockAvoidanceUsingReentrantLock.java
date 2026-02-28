package multithreading.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Res{
	void consume(String tName,String rName) {
		System.out.println(tName+" is using "+rName);
	}
}
public class DeadlockAvoidanceUsingReentrantLock {
	
	Res r1=new Res();
	Res r2=new Res();
	//This lock will be common for all the threads
	ReentrantLock lock= new ReentrantLock();
	
	void task1() {
		try {
			if (lock.tryLock(1,TimeUnit.SECONDS)) {
				System.out.println(
					"t1 acquired the lock");
				r1.consume("t1", "r1");
				r2.consume("t1", "r2");
			}
			else {
				System.out.println(
					"t1 is unable to acquire the lock");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
			System.out.println("t1 released the lock");
		}
	}
	void task2() {
		try {
			if (lock.tryLock(1,TimeUnit.SECONDS)) {
				System.out.println("t2 acquired the lock");
				r1.consume("t2", "r1");
				r2.consume("t2", "r2");
			}
			else {
				System.out.println("t2 is unable to acquire the lock");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
			System.out.println("t2 released the lock");
		}
	}
	
	public static void main(String[] args) {
		try(ExecutorService e=
				Executors.newCachedThreadPool()){
			
			DeadlockAvoidanceUsingReentrantLock d = 
					new DeadlockAvoidanceUsingReentrantLock();
			
			e.submit(d::task1);
			e.submit(d::task2);
		}
	}
}
