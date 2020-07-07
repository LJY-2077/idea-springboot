package test.thread;


/**
 * @author lijy
 * @descriptin
 * @since
 */
public class ThreadMain {
    public static void main(String[] args) {
        ThreadMethod method=new ThreadMethod();
        Thread thread1=new Thread(method,"threatest_1");
        Thread thread2=new Thread(method,"threatest_2");
        thread1.start();
        thread2.start();
    }
}
