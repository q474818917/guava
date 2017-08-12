package com.google.guava.jdk;

import java.util.Optional;

/**
 * Created by wangzx on 2017/3/2.
 */
public class OptionalSample {

    public static void main(String args[]){

        //Optional<String> optional = Optional.empty();   //创建空Optional

        //Optional<String> optional = Optional.of("123");   //创建不为空的Optional

        //Optional<String> optional = Optional.ofNullable(null); //创建允许为空的Optional

        String str = null;
        System.out.println(Optional.ofNullable(str).orElse("null"));
    }

}
