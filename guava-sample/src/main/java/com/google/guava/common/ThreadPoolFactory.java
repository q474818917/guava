package com.google.guava.common;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolFactory {

    private final static ExecutorService exectorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

    public static ExecutorService getThreadPoolExector() {
        return exectorService;
    }
}
