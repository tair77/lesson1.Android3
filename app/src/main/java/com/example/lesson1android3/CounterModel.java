package com.example.lesson1android3;

public class CounterModel {
    int count = 0;


    void increment() {
        ++count;
    }

    void decrement() {
        --count;
    }

    public int getCount() {
        return count;
    }

}
