package com.wq.singleton;

import java.io.*;

/**
 * 懒汉模式，利用静态代码块实现
 */
public class StaticBlockSingleton{

    private static StaticBlockSingleton singleton;
    private StaticBlockSingleton(){

    }

    static {
        singleton = new StaticBlockSingleton();
    }
    public static StaticBlockSingleton getSingleton(){
        return singleton;
    }
}
