package org.example;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class Main {
    static Predicate<Integer> isGreaterThan100 = s -> s >= 101;
    static Predicate<Integer> isLessThan100 = s -> s <= 99;

    public static void main(String[] args) {
//       sample1();
       sample2();
       
    }

    private static void sample2() {
        // applying the Interface at the Calculation Methods
        Calculations add = Calculation::addition;
        Calculations sub = Calculation::subtraction;
        Calculations mul = Calculation::multiplication;
        Calculations div = Calculation::division;
        // Creating CalculationHelper instances for each operation
        CalculationHelper addition =  new CalculationHelper(add);
        CalculationHelper subtract =  new CalculationHelper(sub);
        CalculationHelper multiply =  new CalculationHelper(mul);
        CalculationHelper division =  new CalculationHelper(div);

        // Performing and printing the results of the operations
        System.out.println("Addition:  40 + 5 = " + addition.calculations.calculator(40,5));
        System.out.println("Subtraction: 40 - 5 = " + subtract.calculations.calculator(40,5));
        System.out.println("Multiplication: 40 * 5 = " + multiply.calculations.calculator(40,5));
        System.out.println("Division: 40 / 5 = " + division.calculations.calculator(40,5));

        // Using lambda expressions for custom calculations
        Calculations returnMax = Math::max;
        Calculations sqrt2Numbers = (x,y) -> (x * x * x) + (y * y * y);

        // Creating CalculationHelper instances for custom calculations
        CalculationHelper returnMaxs = new CalculationHelper(returnMax);
        CalculationHelper sqrt2 = new CalculationHelper(sqrt2Numbers);

        System.out.println("Returns Max: 40, 5: " + returnMaxs.calculations.calculator(40,5));
        System.out.println("Square root of 2 number 90 and 3 added together: " + sqrt2.calculations.calculator(90,3)) ;

    }

    private static void sample1() {
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

class CalculationHelper{
    Calculations calculations;
    public CalculationHelper(Calculations calculations) {
        this.calculations = calculations;
    }
}

class SampleClass{
    Sample sample;
    public SampleClass(Sample sample) {
        this.sample = sample;
    }
}
