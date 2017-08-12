package com.google.guava;

import com.google.guava.common.Person;

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

        Person person = new Person("wangzx", "123456", 29);
        Person person2 = new Person("wangsc", "123456", 2);
        System.out.println(person.toString());
        System.out.println(person.hashCode());

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person2);
        for(Person p : personList){
            System.out.println(p.getUsername());
        }

        Collections.sort(personList);
        for(Person p : personList){
            System.out.println(p.getUsername());
        }



    }
}
