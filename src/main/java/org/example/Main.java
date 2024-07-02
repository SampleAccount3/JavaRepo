package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.Collectors;
public class Main {

    public static void main(String[] args) {
        // BiFunction<param1,param2,return type>
        BiFunction<Integer, Integer, String> returnString = (x, y) -> String.valueOf(x + y);
        Consumer<String> display = System.out::println;
        display.accept(returnString.apply(20, 30));

        Function<Integer, String> sqrt = s -> String.valueOf(s * s);
        display.accept(sqrt.apply(3));
    }
}
