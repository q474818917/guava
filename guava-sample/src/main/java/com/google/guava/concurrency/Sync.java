package com.google.guava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dwarf on 2019/2/26.
 * 静态方法作用于类上,会阻塞,
 * 非静态方法作用于对象上,不会阻塞
 */
public class Sync {

    public static synchronized void method1() {
        System.out.println(1);
        try {
           Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i = 0; i < 2; i++) {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    method1();
                }
            });
        }


    }
}
