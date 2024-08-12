package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Animal("Cat", 2);
        Animal dog = new Animal("Dog", 5);
        Animal rat = new Animal("Rat", 1);
        Animal bird = new Animal("Bird", 1);
        Animal horse = new Animal("Horse", 4);
        Animal fish = new Animal("Fish", 100);

        List<Animal> animals = new ArrayList<>();
        animals.add(cat);
        animals.add(dog);
        animals.add(rat);
        animals.add(bird);
        animals.add(horse);
        animals.add(fish);

//        animals.sort(new Comparator<Animal>() {
//            @Override
//            public int compare(Animal o1, Animal o2) {
//                //
//                return Integer.compare(o2.getAge(),o1.getAge());
//            }
//        });
        animals.sort((animal1,animal2)-> Integer.compare(animal1.getAge(),animal2.getAge()));

        animals.stream()
                .toList()
                .forEach(s -> System.out.println(s.getAge() + " " + s.getName()));
    }

}