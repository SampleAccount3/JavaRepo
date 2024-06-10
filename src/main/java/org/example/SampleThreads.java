package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

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

class WorkerThread implements Runnable{
    private String message;
    public WorkerThread(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Thread = " + message);
        processMessage();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println(Thread.currentThread().getName() + "End");
    }
    private void processMessage() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Task implements Runnable{
    private String taskName;
    public Task(String taskName) {
        this.taskName = taskName;
    }
    @Override
    public void run() {
        try{
            for (int i = 0; i <5 ; i++) {
                if (i == 0){
                    Date dt = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss");
                    System.out.println("Initialization time for the task name" + taskName + " = " + sdf.format(dt));

                }else{
                    Date dt = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss");
                    System.out.println("Time of execution for the task name: " + taskName + " = " +sdf.format(dt));
                }
                Thread.sleep(2000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
