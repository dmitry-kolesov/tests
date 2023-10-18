package org.kdb;

public class ThreadChecker implements Runnable {
    Thread threadToCheck;
    MyRunnable runnable;

    public ThreadChecker(Thread threadToCheck, MyRunnable runnable) {
        this.threadToCheck = threadToCheck;
        this.runnable = runnable;
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (true) {
                threadToCheck.join(1);
                if (threadToCheck.isInterrupted()) {
                    runnable.stopThread();
                    System.out.println("interrupted");
                }

                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            runnable.stopThread();
            throw new RuntimeException(e);
        }
    }
}