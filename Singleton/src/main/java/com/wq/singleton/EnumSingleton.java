package com.wq.singleton;

/**
 * 线程安全
 * 不需要延迟加赞加载，最优解
 */
public enum EnumSingleton {
    INSTANCE;

    public void doSomething(){
    }
}
