package org.example;

class SampleThreads extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End of Sample Threads");
    }
}
class SampleRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("The thread is Running");
    }


}
