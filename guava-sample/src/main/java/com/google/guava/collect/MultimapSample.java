package com.google.guava.collect;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;

/**
 * Created by wangzx on 2017/3/3.
 * 一个键对应多个值，Map<K, List<V>>, Map<K, Set<V>>
 */
public class MultimapSample {
    public static void main(String args[]){
        ListMultimap<String, String> listMultimap = ArrayListMultimap.create();
        listMultimap.put("a", "123");
        listMultimap.put("a", "345");
        System.out.println(listMultimap);
    }
}
