package com.example.demo.algorithm.sort.strategy;

import com.example.demo.algorithm.sort.Sort;

public class QuickSort implements Sort {

    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        recursiveSort(list, 0, list.length);
    }

    private  <T extends Comparable<T>> void recursiveSort(T[] list, int left, int right) {
        while(left < right){
            int base = division(list,left,right);
            recursiveSort(list,left,base-1);
            recursiveSort(list,base+1,right);
        }
    }

    private <T extends Comparable<T>> int division(T[] list, int left, int right) {
        T temp = list[left];
        while(left< right) {

        }
        return 0;
    }
}
