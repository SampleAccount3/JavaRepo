package org.example.Components;

public class PersonComponent {
    private String name;
    private int age;
    private String Hobby;

    public PersonComponent(String name, int age, String hobby) {
        this.name = name;
        this.age = age;
        Hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHobby() {
        return Hobby;
    }
}
