package com.cmcc.syw.learning;

/**
 * Created by sunyiwei on 16-3-23.
 */
public final class ImmutableObj {
    private int age;
    private String name;

    public ImmutableObj(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
