package org.example.Components;

public class SalaryComponent {
    private int minSalary;
    private int maxSalary;

    public SalaryComponent(int minSalary, int maxSalary) {
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    @Override
    public String toString() {
        return "SalaryComponent{" +
                "minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }
}
