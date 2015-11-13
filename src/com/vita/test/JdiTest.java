package com.vita.test;

/**
 * Created by HighProphet on 2015/10/21.
 */
public class JdiTest {

    public String doSomething(Person p) {
        return "name is " + p.getName();
    }

    public Person getPerson(){
        return new Person();
    }
}
