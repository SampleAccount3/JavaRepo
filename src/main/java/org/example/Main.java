package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static final int MAX_THREAD = 3;

    public static void main(String[] args) {
//        executorService1();
//        sampleThreadsMethod();
//        sampleRunnableMethod();
        sampleThreadPool();
    }

    private static void sampleThreadPool() {
        Runnable rb1 = new Task("Task 1");
        Runnable rb2 = new Task("Task 2");
        Runnable rb3 = new Task("Task 3");
        Runnable rb4 = new Task("Task 4");
        Runnable rb5 = new Task("Task 5");

        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREAD);

        executorService.execute(rb1);
        executorService.execute(rb2);
        executorService.execute(rb3);
        executorService.execute(rb4);
        executorService.execute(rb5);

        executorService.shutdown();
    }

    public static void sampleRunnableMethod(){
        SampleRunnable sampleRunnable = new SampleRunnable();
        Thread t2 = new Thread(sampleRunnable);
        t2.start();
    }
    public static void sampleThreadsMethod(){
        SampleThreads sampleThreads = new SampleThreads();
        sampleThreads.start();
    }

    public static void executorService1(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10 ; i++) {
            Runnable worker = new WorkerThread(" " + i);
            executorService.execute(worker);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){

        }
        System.out.println("Finished All Threads");
    }

}