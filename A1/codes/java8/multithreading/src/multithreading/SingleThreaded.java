package multithreading;

public class SingleThreaded {
	//Operation 1
	static void printNum() {
		for(int i=1;i<1000;i++) {
			System.out.print(i);
		}
	}
	//Operation 2
	static void printChar() {
		for(char c=1;c<1000;c++) {
			System.out.print(c);
		}
	}
	//main thread(Single Threaded Environment)
	public static void main(String[] args) {
		printNum();
		printChar();
	}
}
