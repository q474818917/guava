package com.google.guava.design_patterns.callback;

public class SimpleTask extends Task {

    @Override
    void consume() {
        System.out.println("正在消费中，消费即将完成");
    }
}
