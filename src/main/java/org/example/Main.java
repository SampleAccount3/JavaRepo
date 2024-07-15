package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    /**      Stream API
     *  input  -> Operation1 -> Operation2 -> OperationN -
     *                                                   |
     *                                                   v
     *                                Output   <- TerminalOperation
     */

    public static void main(String[] args) {
//        streamMapping();
//        streamFiltering();
//        streamSorting();
//        streamForEach();
//        streamOddEven();
//        streamDistinct();
//        streamPeek();
//        streamBuilder();
//        streamGenerate();
//        streamGenerate2();
        streamIterate();
    }

    private static void streamIterate() {
        Stream<Integer> streamIterated = Stream.iterate(1, s -> s + 1 ).limit(20);
        System.out.println(streamIterated.toList());
    }

    private static void streamGenerate2() {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        Stream<Integer> streamGenerated = Stream
                .generate(atomicInteger::getAndIncrement)
                .limit(100)
                .filter(s-> s%5 ==0);
        System.out.println(streamGenerated.toList());
    }

    private static void streamGenerate() {
        Stream<String> streamGenerated = Stream.generate(
                ()-> "Element").limit(10);

        List<String> streamList = streamGenerated.toList();
        System.out.println(streamList);

//        List<String> streamList = streamGenerated
//                .peek(System.out::println)
//                .toList();
    }
    private static void streamBuilder() {
        Stream<Integer> streams = Stream
                .<Integer>builder()
                .add(1)
                .add(2)
                .add(3)
                .add(4)
                .add(5)
                .add(6)
                .add(7)
                .add(8)
                .add(9)
                .add(10)
                .build();

        streams.filter(s-> s % 2 == 0).forEach(System.out::println);
    }

    // Stream Peak is mainly used in debugging
    private static void streamPeek() {
        List<String> names = Arrays.asList("Melares", "Melanio", "Melanio", "Melanio","Flores" );
        names.stream().peek(System.out::println).toList();
    }

    private static void streamDistinct() {
        List<String> names = Arrays.asList("Melares", "Melanio", "Melanio", "Melanio","Flores" );
        List<String> result = names.stream().distinct().toList();
        result.forEach(System.out::println);
    }

    private static void streamOddEven() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11);
        List<Integer> even = numbers
                .stream()
                .filter(x -> x%2 == 0)
                .toList();

        List<Integer> odd = numbers
                .stream()
                .filter(x -> x%2 != 0)
                .toList();

        odd.forEach(System.out::print);
        System.out.println();
        even.forEach(System.out::print);
    }

    /**
     * .forEach - The forEach Methods is used to iterate through every element of the stream
     */
    private static void streamForEach() {
        List<Integer> numbers = Arrays.asList(5,2,2,1,2,5,67,71,2,3,4);
        List<Integer> result = numbers
                .stream()
                .map(x->
                        x*3)
                .sorted()
                .toList();
        result.forEach(System.out::println);

    }

    /**
     * .sort - The sorted method is used to sort the stream
     */
    private static void streamSorting() {
        List<String> names = Arrays.asList("Reflection", "Collection", "Stream", "Ships");
        List<String> result = names.stream().sorted().toList();
        System.out.println(result);
    }

    /**
     * .filter - The filter method is used to select elements as per Predicate passed as an argument
     */
    private static void streamFiltering() {
        List<String> names = Arrays.asList("Reflection", "Collection", "Stream", "Ships");
        List<String> result = names.stream()
                .filter(
                    s-> s.startsWith("S"))
                .toList();
        result.forEach(System.out::println);
    }

    /**
     *  .map - The Map Method is used to return a stream consisting of the results of applying the given function to the elements of this stream.
     */
    private static void streamMapping() {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> squared = nums.stream().map(x-> x*x).toList();
        List<Integer> cubed = nums.stream().map(x-> x*x*x).toList();

        System.out.println("Squared");
        System.out.println(squared);
        System.out.println("Cubed");
        System.out.println(cubed);
    }

}