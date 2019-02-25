package com.google.guava.common;

import java.util.concurrent.atomic.AtomicLong;

public class CounterRateLimiter {

    private static AtomicLong count = new AtomicLong(0);
    private static long time = System.currentTimeMillis();
    private long permits = 0;

    public CounterRateLimiter(long permits) {
        this.permits = permits;
    }

    public boolean tryAquire() {
        if((System.currentTimeMillis() - time) < 1000L) {
            if(count.get() < permits) {
                count.incrementAndGet();
                return true;
            }else {
                return false;
            }
        }else {
            count = new AtomicLong(0);
            time = System.currentTimeMillis();
            return false;
        }
    }

    public static void main(String args[]) {
        AtomicLong al = new AtomicLong(1);
        System.out.println(al.compareAndSet(1, 3)); //如果1==1，则把当前值更新为3
        System.out.println(al.get());

        CounterRateLimiter rateLimiter = new CounterRateLimiter(10);
        int count = 0;
        while(true) {
            count++;
            System.out.println(count);
            System.out.println(rateLimiter.tryAquire());
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
