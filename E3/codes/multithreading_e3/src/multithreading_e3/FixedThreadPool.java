package multithreading_e3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

	public static void print() {
		for (int i = 1; i <= 50; i++) {
			System.out.print(i);
		}
	}

	public static void main(String[] args) {
		// At max 2 threads will be created
		ExecutorService executor = Executors.newFixedThreadPool(2);

		// Thread 1 will perform this task
		executor.execute(FixedThreadPool::print);

		Runnable r = () -> {
			System.out.println("This is task 2");
		};

		// Thread 2 will execute this task
		executor.submit(r);

		executor.shutdown();
	}
}
