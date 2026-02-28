package multithreading;

public class Demo {
	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				System.out.println(i);
				try {
					// Pauses the execution of
					// thread1 for 2 seconds
					Thread.sleep(2000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread1.start();
	}
}
