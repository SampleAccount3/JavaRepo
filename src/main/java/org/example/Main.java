package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        streamPeek();
    }

    // Stream Peak is mainly used in debugging
    private static void streamPeek() {
        List<String> names = Arrays.asList("Melares", "Melanio", "Melanio", "Melanio","Flores" );
        List<String> result = names.stream().peek(System.out::println).toList();
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