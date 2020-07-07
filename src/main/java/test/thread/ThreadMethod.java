package test.thread;

import lombok.SneakyThrows;

/**
 * @author lijy
 * @descriptin
 * @since
 */
public class ThreadMethod implements Runnable {
    private int ticketnum;
    public ThreadMethod(int ticketnum) {
        this.ticketnum=ticketnum;
    }

    @SneakyThrows
    @Override
    public void run() {

        synchronized (this) {
            for (int i = ticketnum; i >0; i--) {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(500);
                System.out.println("剩余票数:" + --ticketnum);
            }
        }

    }
}
