package com.google.guava.util;

import java.util.concurrent.CompletableFuture;

/**
 * Created by wangzx on 2017/4/25.
 */
public class CompletableFutureSample {

    public static void main(String args[]) {

        long t1 = System.currentTimeMillis();
        CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            for(int i = 0; i <= 100; i++) {
                sum += i;
            }
            return sum;
        }).thenAccept(i -> {
            System.out.println(i);
        });


        System.out.println(System.currentTimeMillis() - t1);
    }


}
