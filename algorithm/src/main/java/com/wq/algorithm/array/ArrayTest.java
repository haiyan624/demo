package com.wq.algorithm.array;

public class ArrayTest {

    public static void declare(){

        // 这里必须声明数组大小
        int[] arr1 = new int[5];

        // 直接初始化，不用指定大小
        int[] arr2 = {1,2,3};

        // 二维数组必须指定第一维大小，第二维可指定也可以不指定
        int[][] arr3 = new int[5][];

        // 二维数组初始化，如下
        int[][] arr4 = new int[][]{{11,12},{21,22}};

        // 引申，所有数组初始化，都必须指定一维的大小，剩下可以另说
        int[][][] arr5 = new int[1][][];
    }
}
