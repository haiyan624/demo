package com.example.demo.controller;

import java.util.Stack;

public class Test2 {
    public static void main(String[] args) {
//        int[] arr = new int[10];
//        arr[0]=11;
//        System.out.println(arr.length);
//        Test2.printArr(arr);
//        int[] arr2={3,5,2};
//        System.out.println(arr2.length);
//        System.out.println(arr2[3]);
//        Test2.printArr(arr2);
        System.out.println(Test2.getBucket(0,45));
        System.out.println(Test2.getBucket(1,45123));
        System.out.println(Test2.getBucket(2,45123));
        System.out.println(Test2.getBucket(3,45123));
        System.out.println(Test2.getBucket(4,45123));
    }
    private static int getBucket(int digit, int data){
        int div = (int)Math.pow(10,digit);
        int temp = data/div;
        return temp-temp/10*10;
    }

    private static void printArr(int[] arr){
        System.out.println();
        for(int i = 0; i<arr.length ; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}
