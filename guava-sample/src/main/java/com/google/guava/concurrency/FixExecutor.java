package com.google.guava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dwarf on 2019/2/26.
 * 第6个线程执行时,是否会排队等待 or 抛出异常 or 继续执行
 */
public class FixExecutor {

    public static void main(String args[]) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 6; i++) {
            before();

            es.submit(new Runnable() {
                @Override
                public void run() {
                    while(true){
                    }
                }
            });

            after();
        }

    }

    public static void before() {
        System.out.println("-------before------");
    }

    public static void after() {
        System.out.println("-------after------");
    }
}
