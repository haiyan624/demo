package com.wq.algorithm.thread;

public class MyInterruptTest {
    public static void main(String[] args) {



        final Thread sleepThread = new Thread() {
            @Override
            public void run() {
                boolean flag = true;
                while(!Thread.currentThread().isInterrupted()){
                    if(flag){
                        System.out.println("###"+Thread.currentThread().isInterrupted());
                        System.out.println("###"+Thread.interrupted());
                        System.out.println("###"+Thread.currentThread().isInterrupted());
                        flag = false;
                    }

                }
                System.out.println("***"+Thread.currentThread().isInterrupted());
                System.out.println("***"+Thread.interrupted());
                System.out.println("***"+Thread.currentThread().isInterrupted());
            }
        };
        sleepThread.start();
        sleepThread.isInterrupted();
        final Thread sleepThread2 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                sleepThread.interrupt();
            }
        };
        sleepThread2.start();
    }
}
