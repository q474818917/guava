package com.google.guava.cache;

import com.google.common.base.MoreObjects;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.Objects;

/**
 * Created by wangzx on 2017/3/2.
 * 静态变量不依赖类实例化，如果是public，直接调用GuavaCache.cache
 */
public class GuavaCache {

    private final static Cache<String, String> cache = CacheBuilder.newBuilder().build();
    private final static GuavaCache guavaCache = new GuavaCache();

    public GuavaCache() {

    }

    public static GuavaCache getInstance() {
        return guavaCache;
    }

    public void put(String key, String value) {
        String cached = cache.getIfPresent(key);
        if(cached == null) {
            cache.put(key, value);
        }
    }

    public String get(String key) {
        String cached = cache.getIfPresent(key);
        if(cached != null) {
            return cached;
        }
        return null;
    }

}
