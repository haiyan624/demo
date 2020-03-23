package com.wq.singleton;

/**
 * 饿汉模式：
 * 内部变量用static声明
 * 构造方法用private修饰，不能让别的类创建
 */
public class HungrySingleton {

    /**
     * 类第一次初始化的时候创建
     * 用静态变量static声明
     */
    private static HungrySingleton singleton = new HungrySingleton();

    /**
     * private是重点，不能让其他类声明这个
     */
    private HungrySingleton(){

    }

    /**
     * 对外接口
     * @return
     */
    public static HungrySingleton getSingleton(){
        return singleton;
    }
}
