package org.example;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Optional<String>  sampleObject = optionalSample("Melares");
        System.out.println(sampleObject.isPresent());
        OptionalInt reduced =
                IntStream.range(1, 101).reduce((a, b) -> a + b);

        System.out.println(reduced);
//        System.out.println(sampleObject.get().getName());

    }
    private static Optional<String>  optionalSample(String name) {
        SampleObject sample = new SampleObject();
        sample.setName(null);
//        return Optional.ofNullable(sample);
        return Optional.ofNullable(sample.getName());
    }
}