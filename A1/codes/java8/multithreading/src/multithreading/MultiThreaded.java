package multithreading;

public class MultiThreaded {
	static void printNum() {
		for(int i=1;i<1000;i++) {
			System.out.print(i);
		}
	}
	static void printChar() {
		for(char c=1;c<1000;c++) {
			System.out.print(c);
		}
	}
	public static void main(String[] args) {
		//Thread t1 for printing numbers
		Thread t1= new Thread(
			()->{
			for(int i=1;i<1000;i++) {
				System.out.print(i);
			}
		});
		
		//Thread t2 for printing characters
		Thread t2= new Thread(MultiThreaded::printChar);
		
		//Starting the execution of t1 and t2
		t1.start();
		t2.start();
		
		//Here, both t1 and t2 will be executing
		//parallely at same time along with 
		//main thread
		
	}
}
