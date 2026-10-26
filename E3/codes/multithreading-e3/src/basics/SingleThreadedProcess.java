package basics;
public class SingleThreadedProcess {
    static void printNum(){
        for (int i=1;i<=10_000;i++){
            System.out.print(i);
        }
    }
    static void printChar(){
        for (char i=1;i<=10_000;i++){
            System.out.print(i);
        }
    }
    static void main() {
        /*
        Here, main thread will be responsible for executing
        all the tasks present, one after another
         */
        printNum();
        printChar();
    }
}
