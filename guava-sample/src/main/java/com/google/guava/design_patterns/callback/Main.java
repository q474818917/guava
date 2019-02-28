package com.google.guava.design_patterns.callback;

public class Main {

    public static void main(String args[]) {
        Task task = new SimpleTask();
        task.executeWith(() -> {
            System.out.println("消费完成了");
        });
    }
}
