package com.example.demo.algorithm.sort;

public interface Sort {

    /**
     * 接口排序
     * @param list
     * @param <T>
     */
    <T extends Comparable<T>> void sort(T[] list);
}
