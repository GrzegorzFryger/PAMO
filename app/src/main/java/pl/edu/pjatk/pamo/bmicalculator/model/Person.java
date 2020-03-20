package pl.edu.pjatk.pamo.bmicalculator.model;

import java.io.Serializable;

public class Person implements Serializable {
    private int age;
    private double height;
    private double weight;
    private Gender gender;

    public Person() {
    }

    public Person(int age, double height, double weight, Gender gender) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", gender=" + gender +
                '}';
    }
}

