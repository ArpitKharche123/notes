package executors;
public class Demo {
    static void main() {
        try {
            System.out.println("Start");
            //Makes main thread to wait for 3 seconds
            Thread.sleep(3000);
            System.out.println("End");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
