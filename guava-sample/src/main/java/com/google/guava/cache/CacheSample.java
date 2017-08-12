package com.google.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableList;
import static com.google.common.base.Preconditions.checkArgument;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * I:ConcurrentMap
 *  Abstract:AbstractMap
 *    Class:ConcurrentHashMap
 *
 * guava cache只是本地缓存实现, 类似于ConcurrentHashMap
 * Created by wangzx on 2017/3/2.
 */
public class CacheSample {

    private final static ImmutableList<String> list = ImmutableList.of("北京", "上海");


    public static void main(String args[]) throws ExecutionException {
        /*LoadingCache<Integer, String> loadingCache = CacheBuilder.newBuilder().
                maximumSize(10000).
                expireAfterWrite(10, TimeUnit.MINUTES).
                build(new CacheLoader<Integer, String>() {
                    public String load(Integer key)  {
                        return getByIndex(key);
                    }
                });
        System.out.println(loadingCache.get(-1));*/

    }

    private static String getByIndex(int index) {
        return list.get(index);
    }

}
