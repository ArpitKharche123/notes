package basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Resource{
}
public class DeadLock {
	
	Resource r1 = new Resource();
	Resource r2 = new Resource();
	
	//Deadlock
	void task1() {
		synchronized (r1) {
			System.out.println("T1 locked R1");
			synchronized (r2) {
				System.out.println("T1 locked R2");
			}
		}
	}
	
	void task2() {
		synchronized (r2) {
			System.out.println("T2 locked R2");
			synchronized (r1) {
				System.out.println("T2 locked R1");
			}
		}
	}
	
	//Deadlock avoidance: Lock resources in same order
	// Thread 1 locks r1 then r2
	// Thread 2 locks r1 then r2
	void taskA() {
		synchronized (r1) {
			System.out.println("T1 locked R1");
			synchronized (r2) {
				System.out.println("T1 locked R2");
			}
		}
	}
	void taskB() {
		synchronized (r1) {
			System.out.println("T2 locked R1");
			synchronized (r2) {
				System.out.println("T2 locked R2");
			}
		}
	}
	
	public static void main(String[] args) {
		try(ExecutorService e= Executors.newCachedThreadPool()){
			DeadLock d = new DeadLock();
			
			e.execute(d::taskA);
			e.execute(d::taskB);
		}
	}
}
