package com.wq.singleton;

/**
 * 由于jvm底层缘故，偶尔会出现问题，不建议使用
 */
public class DoubleCheckLockSingleton {
    private static volatile DoubleCheckLockSingleton singleton;

    private DoubleCheckLockSingleton() {

    }

    public static DoubleCheckLockSingleton getSingleton() {
        if (singleton == null) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckLockSingleton();
                }
            }
        }
        return singleton;
    }
}
