package org.kdb;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.function.Function;

public class Main {



    static int Counter = 0;

    public static void checkNullPrinting(){
        Object obj = null;
        System.out.println(String.format("%s", obj));
    }

    public static void main(String[] args) {

        BaseB baseB = new BaseB();
        ((BaseA)baseB).method();
        ((BaseI)baseB).method();

//        UUID uuid = new UUID();
//        System.out.println(uuid);


        Function<String, Integer> getLength = (x1) -> { if(x1 == null || x1.isEmpty()) return -1; return x1.length(); };
        System.out.println(getLength.apply(null));
        System.out.println(getLength.apply(""));
        System.out.println(getLength.apply("null"));

        //Demo task
        Runnable runnableTask = () -> {
            try {
                final int cnt = ++Main.Counter;
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("Current time :: " + LocalDateTime.now());
                Thread currentThread = Thread.currentThread();
                System.out.println(String.format("%d: group: %s; name: %s", cnt, currentThread.getThreadGroup().getName(), currentThread.getName()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        //Executor service instance
        ExecutorService executor = Executors.newFixedThreadPool(10);

        //1. execute task using execute() method
        executor.execute(runnableTask);

        //2. execute task using submit() method
        Future<String> result = executor.submit(runnableTask, "DONE");

        while (result.isDone() == false) {
            try {
                System.out.println("The method return value : " + result.get());
                break;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            //Sleep for 1 second
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Shut down the executor service
        executor.shutdownNow();
    }
}