package org.example;
import java.util.*;
public class BeingObserved extends Observable {

    void Start(){
        setChanged();
        notifyObservers();
    }

}
