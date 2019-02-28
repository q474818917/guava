package com.google.guava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        ExecutorService exectorService = Executors.newFixedThreadPool(1);
        /*ExecutorService exectorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        Lock lock = new RedisLock();
        for(int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {

                    lock.lock("_key_lock");
                    System.out.println("lock--runtime");
                    lock.unLock("_key_lock");
                }
            });
        }*/

    }

}
