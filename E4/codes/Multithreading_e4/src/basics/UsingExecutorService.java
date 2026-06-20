package basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingExecutorService {
	public static void main(String[] args) {
		
		//Pool of Threads
		try(ExecutorService executor=
				Executors.newSingleThreadExecutor()) {

			//Only single Thread will be created
			executor.execute(
					()->{
						String t1 = Thread.currentThread().getName();
						System.out.println(t1+ ": Task 1");
					}
					);
			
			executor.execute(
					()->{
						String t2 = Thread.currentThread().getName();
						System.out.println(t2+ ": Task 2");
					}
					);	
		}
	}
}
