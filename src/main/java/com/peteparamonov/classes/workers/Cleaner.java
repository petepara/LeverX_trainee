package com.peteparamonov.classes.workers;

public class Cleaner extends Worker {

    public Cleaner(String name) {
        super(name);
    }

    @Override
    public void doActivity(){
        System.out.println("Cleaner " + this.getName() + " is cleaning aviary.");
    }

}
