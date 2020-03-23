package com.wq.singleton;

/**
 * 懒汉模式
 * 在getSingleton方法中加锁，这个方法同时只能有一个线程进来
 * 缺点：多线程情况下慢
 */
public class LazySingleton {
    private static LazySingleton singleton;

    private LazySingleton(){

    }

    public static synchronized LazySingleton getSingleton(){
        if(singleton==null){
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
