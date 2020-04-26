package com.wq.algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] list = new int[]{4, 2, 1, 3, 5, 7, 9, -1, 6,5};
        MergeSort mergeSort = new MergeSort();
        mergeSort.merge(list);
        System.out.println(Arrays.toString(list));
    }

    private void merge(int[] list) {
        for(int gap = 1; gap<list.length;gap=gap*2){
            mergePass(list,gap,list.length);
        }
    }

    private void mergePass(int[] list, int gap, int length) {

    }
}
