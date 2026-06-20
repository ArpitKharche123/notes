package basics;

class MyThread1 implements Runnable{
	@Override
	public void run() {
		for(int i=1;i<=10_000;i++) {
			System.out.print(i);
		}
		System.out.println();
	}
}

class MyThread2 extends Thread{
	@Override
	public void run() {
		for(char i=1;i<=10_000;i++) {
			System.out.print(i);
		}
	}
}


public class MultiThreading {
	//main thread
	public static void main(String[] args) {
		
		MyThread1 obj1 = new MyThread1();
		
		//Creating Thread Objects
		Thread t1 = new Thread(obj1);
		MyThread2 t2= new MyThread2();
		
		//Scheduling the execution of Thread
		//t1.start();
		//t2.start();
		
		//Creating a Thread directly 
		
		Thread t3 = new Thread(()->{
			System.out.println("GoodBye!");
		});
		
		t3.start();
		
		//ThreadScheduler 
		
		// Start->Runnable->Running -> Terminated
		//                    |
		//                  Waiting
	}
}
