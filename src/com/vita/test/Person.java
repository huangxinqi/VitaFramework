package com.vita.test;

/**
 * Created by HighProphet on 2015/10/21.
 */
public class Person {
    private String name;
    private int age;
    private float salary;

    public Person() {
        name = "lalala";
        age = 23;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
