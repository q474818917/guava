package com.google.guava.lock;

public interface Lock {

    void lock(String key);

    void unLock(String key);
}
