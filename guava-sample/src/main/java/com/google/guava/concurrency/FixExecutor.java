package com.google.guava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dwarf on 2019/2/26.
 * corePoolSize\maximumPoolSize,
 * 1,当corePoolSize < maximumPoolSize时,且corePoolSize已满,则会新建非核心线程
 * 2,当corePoolSize = maximumPoolSize时,则会进入到队列
 * 3,当队列已满时,则会拒绝task,4种拒绝策略(直接抛弃,抛弃最老的任务,交给调用线程,抛出异常)
 * 4,LinkedBlockingQueue:这个队列是无限制的
 *
 * 第6个线程执行时,会排队等待
 */
public class FixExecutor {

    public static void main(String args[]) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 6; i++) {
            before();

            es.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当前线程是" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(10000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
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
