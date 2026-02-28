package multithreading.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Resource1{
	void use(String tName,String rName) {
		System.out.println(tName+" is using "+rName);
	}
}
public class DeadLockAvoidance {
	//Two resources
		Resource1 r1=new Resource1();
		Resource1 r2=new Resource1();
		
		/*
		 * We can avoid Deadlock
		 * By locking the resource in
		 * same order
		 * 
		 * t1-> lock r1,then r2
		 * t2-> lock r1,then r2
		 */
		
		void task1() {
			synchronized (r1) {
				System.out.println("t1 locked r1");
				r1.use("t1", "r1");
				
				synchronized (r2) {
					System.out.println("t1 locked r2");
					r2.use("t1", "r2");
				}
			}
		}
		
		void task2() {
			synchronized (r1) {
				System.out.println("t2 locked r1");
				r1.use("t2", "r1");
				
				synchronized (r2) {
					System.out.println("t2 locked r2");
					r2.use("t2", "r2");
				}
			}
		}
		
		public static void main(String[] args) {
			try(ExecutorService e=
					Executors.newCachedThreadPool()){
				
				DeadLockAvoidance d=new DeadLockAvoidance();
				
				e.submit(d::task1);
				e.submit(d::task2);
			}
		}
}
