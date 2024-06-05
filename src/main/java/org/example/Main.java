package org.example;

import java.util.function.Function;
import java.util.logging.Logger;

public class Main {
    static Logger logger = Logger.getLogger(Main.class.getName());
    private static Function<Integer,Integer> multiply = x -> x * 2;
    private static Function<Integer,Integer> add = x -> x + x;
    private static Function<Integer, Unit> logOutput = x ->{
        logger.info("Data: " + x);
        return Unit.unit();
    };
    public static Unit execute(Integer input){
        Function<Integer,Unit> pipeline = multiply
                .andThen(add)
                .andThen(logOutput);
        return pipeline.apply(input);
    }

    public static void main(String[] args) {
        execute(10);
    }

    static class Unit {
        // Private constructor prevents instantiation from outside the class
        private Unit() {}

        // A single instance of Unit, representing the only value it can take
        private static final Unit INSTANCE = new Unit();

        // Static method to access the single instance
        public static Unit unit() {
            return INSTANCE;
        }

        @Override
        public String toString() {
            return "Unit";
        }
    }

}