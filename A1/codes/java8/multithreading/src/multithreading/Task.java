package multithreading;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task {
	BigInteger prod = BigInteger.ONE;

	synchronized void mul() {
		for (int i = 1; i <= 100; i++) {
			prod = prod.multiply(BigInteger.valueOf(i));
		}
	}

	synchronized void div() {
		for (int i = 1; i <= 100; i++) {
			prod = prod.divide(BigInteger.valueOf(i));
		}
	}

	public static void main(String[] args) {
		try (ExecutorService exe = Executors.newCachedThreadPool()) {

			Task t = new Task();

			exe.submit(t::mul);
			exe.submit(t::div);

			Thread.sleep(500);

			System.out.println(t.prod);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
