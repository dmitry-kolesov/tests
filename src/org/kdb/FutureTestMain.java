package org.kdb;

import java.util.concurrent.*;

public class FutureTestMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> stringCallable = FutureTestMain::call;

        Future<String> stringFuture = executorService.submit(stringCallable);
        int count = 0;
        while (!stringFuture.isDone()) {
            Thread.sleep(200);
            count++;
            boolean cancelState = stringFuture.cancel(true);
            if (count > 4) System.out.println("cancel: " + cancelState);
        }
        try {
            String result = stringFuture.get();
            System.out.println("Retrieved result from the task - " + result);
            executorService.shutdownNow();
            Thread.sleep(1000);
            count = 0;
        } catch (CancellationException ex) {

            executorService.shutdownNow();
            Thread.sleep(1000);
            count = 0;
        }
    }

    private static String call() {
        double i = 0.0;
        //System.out.println("MyRunnable running");
        while (true) {
            if (((int) i) % 10 == 0) System.out.println(i);
            i += 1.0;
            //Thread.sleep(1);
        }
        //return "";
    }
}