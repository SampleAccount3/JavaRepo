package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ISampleAble<String> IsampleAbleString;
        List<String> names = new ArrayList<>();

        names.add("Melares");
        names.add("Melanio");
        names.add("Kape");
        names.add("Tablet");

        Predicate<String> samplePredicate = s -> s.startsWith("M");
        ISampleAble<String> IsampleAbleStringValue = new ISampleAble<String>() {
            @Override
            public String Start() {
                return "Hello World";
            }
        } ;
//        interfaceInAFunction(IsampleAbleStringValue);
        predicateInAFunction(names);
        System.out.println();
    }

    private static List<String> predicateInAFunction(List<String> names) {
        return names.stream()
                .filter(x -> x.startsWith("K"))
                .collect(Collectors.toList());
    }

    private static void interfaceInAFunction(ISampleAble iSampleAble) {
        System.out.println(iSampleAble.Start());
    }


}