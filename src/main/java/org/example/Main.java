package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        funcInterface();
        sampleInterface();
        noArgInterface();
        numCollectionInterface();

    }

    private static void numCollectionInterface() {
        ArrayList<Integer> numCollection = new ArrayList<>();
        numCollection.add(1);
        numCollection.add(2);
        numCollection.add(3);
        numCollection.add(4);
        numCollection.add(5);
        numCollection.add(6);
        numCollection.forEach(n -> {
            if (n%2 != 0){
                System.out.println(n);
            }
        });
    }

    private static void noArgInterface() {
        NoArgInterface noArgInterface = ()->{
            return "Hello";
        };
        System.out.println(noArgInterface.Hello());
    }

    private static void sampleInterface() {
        SampleInterface sampleInterface = Integer::sum;
        System.out.println(sampleInterface.sum(20,10));
    }

    private static void funcInterface() {
        FuncInterface fObj = (int x) -> System.out.println(x+2);
    }

}