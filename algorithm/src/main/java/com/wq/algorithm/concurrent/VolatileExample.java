package com.wq.algorithm.concurrent;

class VolatileExample {
    int x = 0;
    volatile int b = 0;

    private void write() {
        x = 5;
        b = 1;
    }

    private void read() {
        int dummy = b;
        System.out.println(dummy);
        while (x != 5) {
            System.out.println(x);
        }
        System.out.println(x);
    }

    public static void main(String[] args) throws Exception {
        final VolatileExample example = new VolatileExample();
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                example.read();
            }
        });Thread thread1 = new Thread(new Runnable() {
            public void run() {
                example.write();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}