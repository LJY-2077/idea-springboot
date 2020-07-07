package test.thread;


/**
 * @author lijy
 * @descriptin
 * @since
 */
public class ThreadMain {
    public static void main(String[] args) {
        int a=10;
        ThreadMethod method=new ThreadMethod(a);
        Thread thread1=new Thread(method,"threatest");
        Thread thread2=new Thread(method,"threatest2");
        thread1.start();
        thread2.start();
    }
}
