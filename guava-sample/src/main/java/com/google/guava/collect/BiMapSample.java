package com.google.guava.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * Created by wangzx on 2017/3/3.
 */
public class BiMapSample {

    public static void main(String[] args) {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("a", "123");
        //biMap.put("b", "123"); throws IllegalArgumentException
        System.out.println(biMap);
    }

}
