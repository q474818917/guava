package com.google.guava.collect;


import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wangzx on 2017/3/2.
 */
public class MultisetSample {

    public static void main(String args[]) {
        List<String> list = Arrays.asList("abc", "abc", "123", "345", "345");
        Multiset<String> multiset = HashMultiset.create();
        for(String s : list) {
            multiset.add(s);
        }

        for(Multiset.Entry<String> entry :multiset.entrySet()) {
            System.out.println("key：" + entry.getElement() + ", count:" + entry.getCount());
        }

        System.out.println(multiset);
    }
}
