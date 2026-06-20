package deadlock;

import java.util.concurrent.Executors;

/*
 *   t1 and t2
 *   r1 and r2
 *   
 *   t1 locked r1
 *   t2 locked r2
 *   
 */
class Resource{
	
}
class D{
	Resource r1 = new Resource();
	Resource r2 = new Resource();
	
	void task1() {
		synchronized (r1) {
			System.out.println("thread 1 locked r1");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (r2) {
				System.out.println("thread 1 locked r2");
			}
		}
	}
	
	void task2() {
		synchronized (r2) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("thread 2 locked r2");
			synchronized (r1) {
				System.out.println("thread 2 locked r1");
			}
		}
	}
	/*
	 * Deadlock Avoidance
	 * - by locking the resources in same order
	 * 
	 * thread 1-     synchronized(r1){
	 * 					synchronized(r2){
	 * 						
	 * 					}	
	 * 					}
	 * 
	 * thread 2-     synchronized(r1){
	 * 					synchronized(r2){
	 * 						
	 * 					}	
	 * 					}
	 */
	
}
public class Deadlock {
	public static void main(String[] args) {
		try(var e = Executors.newCachedThreadPool()){
			
			D d = new D();
			e.submit(d::task1);
			e.submit(d::task2);
		}
	}
}
