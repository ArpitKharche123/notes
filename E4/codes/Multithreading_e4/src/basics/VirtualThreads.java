package basics;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VirtualThreads {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		try(var e = Executors.newVirtualThreadPerTaskExecutor()){
			e.execute(
					()->System.out.println("Demo")
					);
			
			 e.submit(
					()->{
						double random = Math.random();
						return random;
					}
					);
		}
	}
}
