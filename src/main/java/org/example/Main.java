package org.example;

public class Main {

    public static void main(String[] args) {
        SampleThreads sampleThreads = new SampleThreads();
        ThreadGroup tg = new ThreadGroup("Group A");
        Thread t1 = new Thread(tg, sampleThreads);
        Thread t2 = new Thread(tg, sampleThreads);
        Thread t3 = new Thread(tg, sampleThreads);
        Thread t4 = new Thread(tg, sampleThreads);
        Thread t5 = new Thread(tg, sampleThreads);

       tg.list();
    }

}

class SampleThreads implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}