package org.example;

public class AsyncCallback {
    public void performAsyncCallback(Runnable runnable){
        new Thread(()->{
            System.out.println("Processing Async Task");
            runnable.run();
        }).start();
    }

}
