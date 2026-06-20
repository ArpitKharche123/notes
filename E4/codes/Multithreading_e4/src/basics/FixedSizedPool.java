package basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedSizedPool {
	public static void main(String[] args) {
		//Maximum n Threads will be generated
		try(ExecutorService e = Executors.newFixedThreadPool(2)){
			e.execute(
					()->{
						String tName = Thread.currentThread().getName();
						System.out.println(tName+ ": Task 1");
					}
					);
			
			e.execute(
					()->{
						String tName = Thread.currentThread().getName();
						System.out.println(tName+ ": Task 2");
					}
					);
			
			e.execute(
					()->{
						String tName = Thread.currentThread().getName();
						System.out.println(tName+ ": Task 3");
					}
					);
		}
	}
}
