package com.wq.algorithm.sort;

public class MergeSort {

    private void merge(int[] list) {
        for(int gap = 1; gap<list.length;gap=gap*2){
            mergePass(list,gap,list.length);
        }
    }

    private void mergePass(int[] list, int gap, int length) {

    }


}
