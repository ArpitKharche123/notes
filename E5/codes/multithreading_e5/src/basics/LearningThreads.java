package basics;

class MyThread1 implements Runnable{
	@Override
	public void run() {
		for(int i= 1; i<= 10_000;i++) {
			System.out.print(i);
		}
	}
}

class MyThread2 extends Thread{
	@Override
	public void run() {
		for(char i= 1; i<= 10_000;i++) {
			System.out.print(i);
		}
	}
}

public class LearningThreads {
	//main thread
	public static void main(String[] args) {
		
		//Creating User defined platform Threads
		MyThread1 t= new MyThread1();
		
		Thread t1 = new Thread(t);
		
		MyThread2 t2 = new MyThread2();
		
		Thread t3= new Thread(
				()-> System.out.println("Thread 3")
				);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
