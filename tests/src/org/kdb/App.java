package org.kdb;
import java.lang.Thread;

public class App {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable runnable = new MyRunnable(); // or an anonymous class, or lambda...

        Thread thread = new Thread(runnable);
        thread.setPriority(3);
        thread.start();
        ThreadChecker checker = new ThreadChecker(thread, runnable);

        Thread thread1 = new Thread(checker);
        Thread.sleep(1000);
        thread1.start();

        Thread.sleep(1000);
        thread.interrupt();
        Thread.sleep(5000);
    }

    public class A {
        public void methodToOverride(){
        }
    }

    public class B extends A{
        @Override
        public void methodToOverride(){
        }
    }


}