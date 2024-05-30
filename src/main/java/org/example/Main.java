package org.example;

import java.util.ArrayList;

public class Main {
        /**
     * PSVM
     */
    public static void main(String[] args) {
        ArrayList<String> value1 = new ArrayList<>();
        value1.add("Melares");
        value1.add("Srolef");
        value1.add("Douppy");
        value1.remove("Douppy");
        System.out.println("people = " + value1);
        // output: people = [Melares, Srolef]

        ArrayList<String> value2 = new ArrayList<>();
        // addAll Adds the contents of people to human
        value2.addAll(value1);
        System.out.println("human = " + value2);
        // output: human = [Melares, Srolef]

        value2.clear();
        System.out.println(value2);
        // output: []

        // cast the people to (ArrayList<String>) before assigning to human
        value2 = (ArrayList<String>) value1.clone();
        System.out.println(value2);
//        output: [Melares, Srolef]
        System.out.println("Does Human Contains Melares? " + (value2.contains("Melares")? "Yes": "No"));
//        output: Does Human Contains Melares? Yes
        System.out.println("What's in the index 0? "+ value2.get(0));
//         output: Melares
        System.out.println("What is the index of Melares? " + value2.indexOf("Melares"));
//        output: What is the index of Melares? 0

        value2.add("Sample");
        value2.add("Sample2");

        System.out.println(value2);
//        Removes the contents of value1 to value2
        value2.removeAll(value1);
        System.out.println(value2);
        System.out.println("Removes index 0 from value2 " + value2.remove(0));
//        output: Removes index 0 from value2 Sample
        System.out.println("What is the Size of value2: " + value2.size() );
//        output: What is the Size of value2: 1
        System.out.println("Is value2 empty? " + value2.isEmpty());
//        output: Is value2 empty? false
//            tbc tm
    }
}