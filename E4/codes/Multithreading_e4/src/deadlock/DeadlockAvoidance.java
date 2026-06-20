package deadlock;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Res{
	String name;

	public Res(String name) {
		this.name = name;
	}
	void use(String tName) {
		System.out.println(tName+" is using "+name);
	}
}
class Test{
	Res r1 = new Res("resource 1");
	Res r2 = new Res("resource 2");
	
	ReentrantLock lock = new ReentrantLock();
	
	void task1() {
		try {
			//acquires a lock for a thread or wait for
			//1 second if lock is not available
			//If lock is not acquired in 1 second,
			//thread will be terminated !
			if (lock.tryLock(1, TimeUnit.SECONDS)) {
				System.out.println("thread 1 acquired the lock");
				r1.use("thread 1");
				r2.use("thread 1");
			}else {
				System.err.println("thread 1 failed to acquire the lock");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
			System.out.println("thread 1 released the lock");
			System.out.println("------------------------");
		}
	}
	void task2() {
		try {
			if (lock.tryLock(1, TimeUnit.SECONDS)) {
				System.out.println("thread 2 acquired the lock");
				r1.use("thread 2");
				r2.use("thread 2");
			}else {
				System.err.println("thread 2 failed to acquire the lock");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
			System.out.println("thread 2 released the lock");
			System.out.println("------------------------");
		}
	}
	
}
public class DeadlockAvoidance {
	public static void main(String[] args) {
		try(var e= Executors.newVirtualThreadPerTaskExecutor()){
			Test t= new Test();
			e.submit(t::task1);
			e.submit(t::task2);
		}
	}
}
