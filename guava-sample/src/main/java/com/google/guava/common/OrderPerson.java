package com.google.guava.common;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

/**
 * Created by wangzx on 2017/3/2.
 */
public class OrderPerson extends Ordering<OrderPerson> {

    private String username;
    private String password;
    private int age;

    public OrderPerson(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.username, this.password);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("username", this.username)
                .add("password", this.password).toString();
    }

    @Override
    public int compare(OrderPerson left, OrderPerson right) {
        return Ints.compare(left.age, right.age);
    }
}
