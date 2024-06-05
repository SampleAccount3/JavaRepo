package org.example;

import org.w3c.dom.ls.LSOutput;

public class Main {

    public static void main(String[] args) {
        FuncInterface fObj = (int x) -> System.out.println(x+2);
        SampleInterface sampleInterface = Integer::sum;
        System.out.println(sampleInterface.sum(20,10));
        NoArgInterface noArgInterface = ()->{
            return "Hello";
        };
        System.out.println(noArgInterface.Hello());

    }

}