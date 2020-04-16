package com.wq.rabbit.confirm;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        SortedSet<Long> set = Collections.synchronizedSortedSet(new TreeSet<Long>());
        set.add(5L);
        set.add(7L);
        set.add(6L);
        set.add(8L);
        set.add(1L);
        System.out.println(set);
        set.headSet(5L).clear();
        System.out.println(set);
    }
}
