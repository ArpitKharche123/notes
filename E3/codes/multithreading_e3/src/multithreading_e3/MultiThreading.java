package multithreading_e3;

public class MultiThreading {
	public static void printNum() {
		for(int i=1;i<=1000;i++) {
			System.out.print(i);
		}
	}
	public static void printChar() {
		for(char i=1;i<=1000;i++) {
			System.out.print(i);
		}
	}
	public static void main(String[] args) {
		
		Thread t1=new Thread(MultiThreading::printNum);
		
		Thread t2=new Thread(
				()->{
					System.out.println("Task t2");
				}
				);
		Thread t3= new Thread(MultiThreading::printChar);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
