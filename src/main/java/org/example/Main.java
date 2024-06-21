package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class Main {
    static Predicate<Integer> isEven = s -> s % 2 == 0;
    static Predicate <Integer> isOdd = s -> s % 2 == 1;
    static Predicate<String> startsWithJ = s -> s.startsWith("J");
    static Predicate<String> lengthGreaterThan5 = s -> s.length() > 5;
    static Predicate<String> startsWithJAndGreaterThan5 = startsWithJ.and(lengthGreaterThan5);
    static Predicate<String> startsWithJOrGreaterThan5 = startsWithJ.or(lengthGreaterThan5);
    static Predicate<String> doesNotStartwithJ = startsWithJ.negate();

    public static void main(String[] args) {

//        System.out.println( isEven.test(6));
//        System.out.println(isOdd.test(3));
        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<String> nameList = Arrays.asList("John","Johnss", "Wick", "Sample", "Jones" );

//        isOddOrEven(numberList);
//        isEven(numberList);
//        isOdd(numberList);
        System.out.println("-----List-----");

        System.out.println(nameList);

        System.out.println("-----And-----");

        System.out.println("Starts with J and greater than 5");

        nameList.stream()
                .filter(startsWithJAndGreaterThan5)
                .forEach(System.out::println);

        System.out.println("-----Or-----");

        System.out.println("Starts with or greater than 5");

        nameList.stream()
                .filter(startsWithJOrGreaterThan5)
                .forEach(System.out::println);

        System.out.println("-----Negate-----");

        System.out.println("Does Not Start with J");

        nameList.stream()
                .filter(doesNotStartwithJ)
                .forEach(System.out::println);

    }

//    private static void jGreaterThan5(List<String> nameList) {
//        List<String> jGreaterThan5List = nameList.stream()
//                .
//    }

    private static void isOdd(List<Integer> numberList) {
        List<Integer> evenNumbers = numberList.stream()
                .filter(isOdd)
                .toList();
        System.out.println(evenNumbers);
    }

    private static void isEven(List<Integer> numberList) {
        List<Integer> evenNumbers = numberList.stream()
                .filter(isEven)
                .toList();
        System.out.println(evenNumbers);
    }


    private static void isOddOrEven(List<Integer> numberList) {
        for (Integer number: numberList){
            System.out.println(number);
            System.out.println("Is Even: " + isEven.test(number));
            System.out.println("Is Odd: " + isOdd.test(number));
        }
    }

}