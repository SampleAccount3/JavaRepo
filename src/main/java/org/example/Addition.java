package org.example;

public class Addition implements Computation{
    @Override
    public double compute(double x, double y) {
        return x + y;
    }
}
