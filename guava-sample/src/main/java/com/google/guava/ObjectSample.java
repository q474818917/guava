package com.google.guava;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.guava.common.Person;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by wangzx on 2017/3/2.
 */
public class ObjectSample {

    public static void main(String args[]) {

        System.out.println(Objects.equals(null, "123"));    //支持null的equals

        Person person = new Person("wangzx", "123456", 29, 100.2);
        Person person2 = new Person("wangsc", "123456", 2, 100.2);
        System.out.println(person.toString());
        System.out.println(person.hashCode());

        List<Person> totalList = Lists.newArrayList();

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person2);

        totalList.addAll(personList);
        //Collections.sort(personList);
        for(Person p : totalList){
            System.out.println(p.getUsername());
        }
    }

}
