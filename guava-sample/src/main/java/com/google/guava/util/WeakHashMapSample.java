package com.google.guava.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wangzx on 2017/4/21.
 */
public class WeakHashMapSample {

    public static void main(String args[]) {

        String w1 = new String("one");
        String w2 = new String("two");
        String w3 = new String("three");
        // 新建WeakHashMap
        Map wmap = new WeakHashMap();

        // 添加键值对
        wmap.put(w1, "w1");
        wmap.put(w2, "w2");
        wmap.put(w3, "w3");

        // 打印出wmap
        System.out.printf("\nwmap:%s\n",wmap );

        // containsKey(Object key) :是否包含键key
        System.out.printf("contains key two : %s\n",wmap.containsKey("two"));
        System.out.printf("contains key five : %s\n",wmap.containsKey("five"));

        // containsValue(Object value) :是否包含值value
        System.out.printf("contains value 0 : %s\n",wmap.containsValue(new Integer(0)));

        // remove(Object key) ： 删除键key对应的键值对
        wmap.remove("three");

        System.out.printf("wmap: %s\n",wmap );



        // ---- 测试 WeakHashMap 的自动回收特性 ----

        // 将w1设置null。
        // 这意味着“弱键”w1再没有被其它对象引用，调用gc时会回收WeakHashMap中与“w1”对应的键值对
        w1 = null;
        // 内存回收。这里，会回收WeakHashMap中与“w1”对应的键值对
        System.gc();

        // 遍历WeakHashMap
        Iterator iter = wmap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry en = (Map.Entry)iter.next();
            System.out.printf("next : %s - %s\n",en.getKey(),en.getValue());
        }
        // 打印WeakHashMap的实际大小
        System.out.printf(" after gc WeakHashMap size:%s\n", wmap.size());

        Map<String, String> map = new HashMap<>();
        String s1 = new String("sh");
        String s2 = new String("bj");
        map.put(s1, "上海");
        map.put(s2, "北京");

        s1 = null;
        System.gc();

        map.forEach((k, v) -> {
            System.out.println(k + "->" + v);
        });

    }

}
