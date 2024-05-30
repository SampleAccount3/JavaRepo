package org.example;

import java.util.ArrayList;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        /**
     * PSVM
     */
    public static void main(String[] args) {
        ArrayList<String> people = new ArrayList<>();
        people.add("Melares");
        people.add("Srolef");
        people.add("Douppy");
        people.remove("Douppy");
        System.out.println("people = " + people);
        // output: people = [Melares, Srolef]

        ArrayList<String> human = new ArrayList<>();
        // addAll Adds the contents of people to human
        human.addAll(people);
        System.out.println("human = " + human);
        // output: human = [Melares, Srolef]
    }
}