package synchronization;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class T{
	//Internally synchronized in nature
	AtomicInteger count = new AtomicInteger(0);
	
	void increment() {
		count.incrementAndGet();
	}
}
public class UsingAtomicInteger {
	public static void main(String[] args) {
		try(var e = Executors.newVirtualThreadPerTaskExecutor() ){
			T t= new T();
			e.submit(
					()->{
						for(int i=0;i<1_00_000;i++) {
							t.increment();
						}	
					}
					);
			
			e.submit(
					()->{
						for(int i=0;i<1_00_000;i++) {
							t.increment();
						}	
					}
					);
			Thread.sleep(500);
			System.out.println(t.count);
			
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
