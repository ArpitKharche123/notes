package basics;

public class SingleThreaded {
	
	static void printNum() {
		for(int i=1;i<=10_000;i++) {
			System.out.print(i);
		}
		System.out.println();
	}
	static void printChar() {
		for(char i=1;i<=10_000;i++) {
			System.out.print(i);
		}
	}
	
	//main thread - only thread which will be executing all
	//the tasks
	public static void main(String[] args) {
		printNum();
		printChar();
		//Here one task will be on hold until the first is 
		//executed completely
	}
}
