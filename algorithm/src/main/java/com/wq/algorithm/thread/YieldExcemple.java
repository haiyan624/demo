package com.wq.algorithm.thread;

/**
 * yield只会让出相同优先级
 */
public class YieldExcemple {

    public static void main(String[] args) {
        Thread threada = new ThreadA();
        Thread threadb = new ThreadB();
        Thread threadC = new ThreadC();
        // 设置优先级:MIN_PRIORITY最低优先级1;NORM_PRIORITY普通优先级5;MAX_PRIORITY最高优先级10
        threada.setPriority(Thread.MIN_PRIORITY);
        threadb.setPriority(Thread.MAX_PRIORITY);
        threadC.setPriority(Thread.MAX_PRIORITY);

        threada.start();
        threadb.start();
        threadC.start();
    }
}

class ThreadA extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadA--" + i);
            Thread.yield();
        }
    }
}

class ThreadC extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadC--" + i);
            Thread.yield();
        }
    }
}
class ThreadB extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadB--" + i);
            Thread.yield();
        }
    }
}