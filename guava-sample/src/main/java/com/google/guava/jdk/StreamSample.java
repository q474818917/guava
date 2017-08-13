package main.java.com.google.guava.jdk;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 使用stream操作后,集合还是在的
 * Created by dwarf on 17/8/13.
 */
public class StreamSample {
    public static void main(String args[]) {
        Person p1 = new Person("1", "wangzx", "北京", 50);
        Person p2 = new Person("2", "zhoujl", "上海", 20);
        List<Person> list = Lists.newArrayList(p1, p2);

        List<String> strList = list.stream().
                filter(p -> p.getCity().equals("北京")).
                map(Person::getId).
                collect(Collectors.toList());

        int total = list.stream().map(Person::getAge).reduce(0, Integer::sum);
    }

    static class Person {
        private String id;
        private String username;
        private String city;
        private int age;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person() {

        }

        public Person(String id, String username, String city, int age) {
            this.id = id;
            this.username = username;
            this.city = city;
            this.age = age;
        }
    }
}

