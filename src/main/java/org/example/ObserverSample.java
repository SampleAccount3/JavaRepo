package org.example;
import  java.util.*;
public class ObserverSample implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Observer Called" +arg.getClass().getName());
    }
}
