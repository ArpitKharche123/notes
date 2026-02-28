package multithreading.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Resource{
	void use(String tName,String rName) {
		System.out.println(tName+" is using "+rName);
	}
}
public class DeadLock {
	
	//Two resources
	Resource r1=new Resource();
	Resource r2=new Resource();
	
	//t1 will perform this task
	void task1() {
		//t1 trying to lock r1
		synchronized (r1) {
			System.out.println("t1 locked r1");
			r1.use("t1", "r1");
			
			//t1 trying to lock r2
			synchronized (r2) {
				System.out.println("t1 locked r2");
				r2.use("t1", "r2");
			}
		}
	}
	
	//t2 will perform this task
	void task2() {
		//t2 trying to lock r2
		synchronized (r2) {
			System.out.println("t2 locked r2");
			r2.use("t2", "r2");
			
			//t2 trying to lock r1
			synchronized (r1) {
				System.out.println("t2 locked r1");
				r1.use("t2", "r1");
			}
		}
	}
	
	public static void main(String[] args) {
		try(ExecutorService e=
				Executors.newCachedThreadPool()){
			
			DeadLock d=new DeadLock();
			
			e.submit(d::task1);
			e.submit(d::task2);
		}
	}
}
