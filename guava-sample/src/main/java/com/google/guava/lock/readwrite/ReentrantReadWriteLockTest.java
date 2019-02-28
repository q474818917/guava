package com.google.guava.lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        //开启20个读任务
        for (int i = 1; i <= 5; i++) {
            new Thread(new ReadTask(lock)).start();
        }

        //开启20个写任务
        for (int i= 1;i<=5;i++){
            new Thread(new WriteTask(lock)).start();
        }
    }
}
