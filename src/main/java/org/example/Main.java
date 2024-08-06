package org.example;
public class Main {
    public static void main(String[] args) {
        Computation computation;
        int choices = 1,
                x = 5,
                y = 222;
        Addition add = new Addition();
        Subtraction sub = new Subtraction();
        Multiplication mul = new Multiplication();
        Division div = new Division();

        switch (choices){
            case 1:
                computation = add;
                System.out.println(computation.compute(x,y));
                break;
            case 2:
                computation = sub;
                System.out.println(computation.compute(x,y));
                break;
            case 3:
                computation = mul;
                System.out.println(computation.compute(x,y));
                break;
            case 4:
                computation = div;
                System.out.println(computation.compute(x,y));
                break;
        }
    }
}