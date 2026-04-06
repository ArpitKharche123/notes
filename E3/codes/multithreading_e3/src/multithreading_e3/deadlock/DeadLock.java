package multithreading_e3.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Resource{
}
public class DeadLock {
	
	 Resource r1=new Resource();
	 Resource r2=new Resource();
	
	  void task1() {
		 synchronized (r1) {
			System.out.println("thread 1 locked r1");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (r2) {
				System.out.println("thread 1 locked r2");
			}
		}
	 }
	 
	  void task2() {
		 synchronized (r1) {
				System.out.println("thread 2 locked r1");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (r2) {
					System.out.println("thread 2 locked r2");
				}
			}
	 }
	
	public static void main(String[] args) {
		try (ExecutorService exe = 
				Executors.newFixedThreadPool(2)) {
			
			DeadLock d=new DeadLock();
			
			exe.submit(d::task1);
			exe.submit(d::task2);
			
		}
	}
}
