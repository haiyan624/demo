package com.wq.algorithm;

public class B extends A{

    public static int f;

    static {
        System.out.println("init B");

    }

    public B(){
        System.out.println("construction");
    }

} 
