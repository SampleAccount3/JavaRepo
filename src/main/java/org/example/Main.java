package org.example;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class Main {
    static Predicate<Integer> isGreaterThan100 = s -> s >= 101;
    static Predicate<Integer> isLessThan100 = s -> s <= 99;

    public static void main(String[] args) {
        int x = 2000;
        int y = 100;
        Predicate<Integer> isEqualTo100 = s -> s == y;

        Sample sampleLambda = Integer::sum;
        Sample sampleLambda2 = Integer::max;

        SampleClass sampleClass = new SampleClass(sampleLambda);
        SampleClass sampleClass2 = new SampleClass(sampleLambda2);

        int result = sampleClass.sample.lambSample(98,2);
        int result2 = sampleClass2.sample.lambSample(x,y);
        System.out.println(result);
        System.out.println("Result 2 " + result2);
        System.out.println(isEqualTo100.test(result) ? "Is equal to 100": isGreaterThan100.test(result)? "Greater than 100" : "Is Less than 100");
    }
}
interface Sample{
    int lambSample(int x, int y);
}
class SampleClass{
    Sample sample;
    public SampleClass(Sample sample) {
        this.sample = sample;
    }
}
