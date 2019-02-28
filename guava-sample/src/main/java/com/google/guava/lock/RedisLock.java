package com.google.guava.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * 增加Jedis dependency
 */
public class RedisLock implements Lock {

    private static Logger logger = LoggerFactory.getLogger(RedisLock.class);

    private volatile boolean locked = false;
    private static final String LOCKED = "TRUE";
    private static final long TIME_OUT = 500;
    public static final int EXPIRE = 60;
    private JedisUtil.Strings strings;
    private JedisUtil.Keys keys;


    public RedisLock() {
        JedisUtil jedisUtil = JedisUtil.getInstance();
        strings = jedisUtil.new Strings();
        keys = jedisUtil.new Keys();
    }

    public void lock(String key, long timeout) {
        long nano = System.nanoTime();
        timeout *= 1000000;
        final Random r = new Random();
        try {
            while ((System.nanoTime() - nano) < timeout) {
                logger.info("当前线程是{}", Thread.currentThread().getName());
                if (strings.setnx(key, LOCKED) == 1) {
                    logger.info("设置线程是{}", Thread.currentThread().getName());
                    locked = true;
                    break;
                }
                Thread.sleep(3, r.nextInt(500));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void lock(String key) {
        lock(key, TIME_OUT);
    }

    @Override
    public void unLock(String key) {
        if(locked) {
            logger.info("{}，当前线程是{}", keys.del(key), Thread.currentThread().getName());
        }
    }
}
