package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
public class Main {
    /**
     * Supplier does not accept arguments but returns T values
     */
    public static void main(String[] args) {
        Supplier<Integer> sumOf2nums = ()-> 20+30;
        System.out.println(sumOf2nums.get());

        Supplier<Double> randomNumbers = Math::random;
        System.out.println(randomNumbers.get());
    }

}

