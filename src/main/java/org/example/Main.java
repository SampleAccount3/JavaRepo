package org.example;

public class Main {

    public static void main(String[] args) {
//        SampleThreadsFunc();
//       sampleRunnableFunc();

    }

    private static void sampleRunnableFunc() {
        SampleRunnable sampleRunnable = new SampleRunnable();
        Thread threadObj = new Thread(sampleRunnable);

        System.out.println(threadObj.getState());
        threadObj.start();
        System.out.println(threadObj.getState());

        try {
            threadObj.join();
            System.out.println(threadObj.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void SampleThreadsFunc() {
        SampleThreads sampleThreads = new SampleThreads();
        System.out.println("Sample1");
        System.out.println(sampleThreads.getState());
        sampleThreads.start();
        System.out.println("Starting");

        try {
            sampleThreads.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sampleThreads.getState());
    }


}