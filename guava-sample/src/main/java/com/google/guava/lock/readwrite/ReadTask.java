package com.google.guava.lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadTask implements Runnable {

    private ReentrantReadWriteLock lock;

    public ReadTask(ReentrantReadWriteLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        String name = Thread.currentThread().getName();
        System.out.println(name + " 尝试请求read锁......");
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        readLock.lock();
        System.out.println(name + "已拿到read锁, 开始处理业务");

        // 模拟业务处理
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        readLock.unlock();
        System.out.println(name + "释放read锁....");
    }
}