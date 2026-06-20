package basics;

import java.util.concurrent.Executors;

public class CachedThreadPool {
public static void main(String[] args) {
	//New Thread will be created for each new task
	try(var e = Executors.newCachedThreadPool()){
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
