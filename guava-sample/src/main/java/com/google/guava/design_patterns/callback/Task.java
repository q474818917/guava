package com.google.guava.design_patterns.callback;

public abstract class Task {

    public final void executeWith(Callback callback) {
        consume();
        if(callback != null) {
            callback.execute();
        }
    }

    abstract void consume();

}
