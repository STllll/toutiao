package com.nowcoder;

import org.junit.Test;

class MyThread extends Thread {
    private int tid ;

    public MyThread(int tid){
        this.tid = tid;
    }
    @Override
    public void run() {
        try{
            for (int i = 0;i <10; i++) {
                Thread.sleep(1000);

                System.out.println(String.format("T%d:%d", tid, i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
public class MultiThread {
    private static Object obj = new Object();

    public static void TestThread() {
        for (int i = 0; i< 10; ++i) {
            new MyThread(i).start();
        }
    }

    public static void testSynchronized1() {
        synchronized (obj) {
            try{
                for (int i = 0;i <10; i++) {
                    Thread.sleep(1000);

                    System.out.println(String.format("T3:%d",  i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void testSynchronized2() {
        synchronized (obj) {
            try{
                for (int i = 0;i <10; i++) {
                    Thread.sleep(1000);

                    System.out.println(String.format("T4:%d",  i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args){
        testSynchronized1();
        testSynchronized2();
    }
}
