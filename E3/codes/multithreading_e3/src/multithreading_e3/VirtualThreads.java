package multithreading_e3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreads {
	public static void main(String[] args) {
		try(ExecutorService exe=
				Executors.newVirtualThreadPerTaskExecutor();
				) {
			exe.execute(()->{
				System.out.println("Task 1");
			});
		}
	}
}
