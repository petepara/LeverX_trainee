package com.peteparamonov.classes.workers;

import com.peteparamonov.api.Active;

public class Worker implements Active {
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public void doActivity() {
        System.out.println(name + "do something that makes dogs' life better.");
    }

    public Worker(String name) {
        this.name = name;
    }
}
