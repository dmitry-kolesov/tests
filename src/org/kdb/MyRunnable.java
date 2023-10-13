package org.kdb;

public class MyRunnable implements Runnable {
    boolean running = true;
    public void run() {
        double i = 0.0;
        //System.out.println("MyRunnable running");
        while (true) {
            System.out.println(i);
            i += 1.0;
        }
    }

    public void stopThread() {
        running = false;
        //interrupt();
    }
}