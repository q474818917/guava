package com.google.guava.hash;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

import java.util.Arrays;

/**
 * guava中的BloomFilter必须配合Funnel使用，Funnel类似于身份指纹
 * 结果通过BloomFilter.mightContain()
 * 可以准确判断一个元素不存在，不能准确判断一个元素存在
 * Created by wangzx on 2017/4/25.
 */
public class BloomFilterSample {
    public static void main(String argsp[]) {
        Person p1 = new Person("测试", "123456");
        Person p2 = new Person("测试1", "123456");

        Funnel<Person> personFunnel = new Funnel<Person>() {
            @Override
            public void funnel(Person from, PrimitiveSink into) {
                into.putString(from.getPassword(), Charsets.UTF_8)
                        .putString(from.getUsername(), Charsets.UTF_8);
            }
        };
        BloomFilter<Person> bloomFilter = BloomFilter.create(personFunnel, 5);

        Arrays.asList(p1, p2).stream().forEach(p -> {
            bloomFilter.put(p);
        });

        System.out.println(bloomFilter.mightContain(p1));
    }
}

class Person {
    private String username;
    private String password;

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}