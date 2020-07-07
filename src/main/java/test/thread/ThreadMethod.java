package test.thread;

import lombok.SneakyThrows;

/**
 * @author lijy
 * @descriptin
 * @since
 */
public class ThreadMethod implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                Thread.sleep(1000);
                System.out.println("执行结果:" + i);
            }
        }

    }
}
