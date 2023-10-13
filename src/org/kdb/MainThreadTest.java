package org.kdb;

public class MainThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new MyRunnable(); // or an anonymous class, or lambda...

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(10000);
        thread.interrupt();
    }
}