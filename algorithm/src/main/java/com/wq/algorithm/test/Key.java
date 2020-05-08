package com.wq.algorithm.test;

import java.util.Objects;

public class Key {
    private int value;
    public Key(int value){
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return value%2;
    }
}
