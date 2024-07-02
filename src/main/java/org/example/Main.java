package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;
public class Main {

    /**
     * Consumer is a functional interface that accepts 1 argument and Doesn't return a value
     */

    public static void main(String[] args) {
//        consumerSample1();
//        consumerSample2();
        consumerSample3();
    }

    private static void consumerSample3() {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        // multiply the contents of the list by 2
        Consumer<List<Integer>> addAllContents = x ->{
            for (int i = 0; i < x.size() ; i++) {
                x.set(i, 2 * x.get(i));
            }
            System.out.println(x);
        };
        addAllContents.accept(numbers);
    }

    private static void consumerSample2(){
        // displays the Contents of list
        Consumer<List<Integer>> displayList = x -> {
            x.stream().forEach(y -> System.out.println(y + " "));
        };
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        displayList.accept(numbers);
    }

    private static void consumerSample1() {
        // displays the string and the square root and cube root of an integer
        Consumer<String> display =System.out::println;
        Consumer<Integer> sqrt = x -> System.out.println(x*x);
        Consumer<Integer> cbrt = x -> System.out.println(x*x*x);
        sqrt.accept(3);
        cbrt.accept(3);
        display.accept("Melares");
    }
}

