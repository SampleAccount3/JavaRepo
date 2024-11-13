package org.example;

public class Main {

    public static void main(String[] args) {
        ObservableClass observableClass = new ObservableClass();
        ObservableChannel channel1 = new ObservableChannel("channel1");
        ObservableChannel channel2 = new ObservableChannel("channel2");
        ObservableChannel channel3 = new ObservableChannel("channel3");

        observableClass.addChannels(channel1);
        observableClass.addChannels(channel2);
        observableClass.addChannels(channel3);
        observableClass.setNews("Set News to all Channel");
        observableClass.removeObserver(channel1);
        observableClass.setNews("Removed the Channel 1");
        observableClass.addChannels(channel1);
        observableClass.setNews("Added Channel 1");

    }

}