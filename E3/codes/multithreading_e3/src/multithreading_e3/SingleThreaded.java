package multithreading_e3;

public class SingleThreaded {
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
	
	//main thread
	public static void main(String[] args) {
		printNum();
		printChar();
	}
}
