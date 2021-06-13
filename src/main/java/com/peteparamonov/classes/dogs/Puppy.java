package com.peteparamonov.classes.dogs;

import javax.persistence.Entity;

@Entity
public class Puppy extends Dog {

    public Puppy(int age, String name, boolean isHealthy) {
        super(age, name, isHealthy);
        this.setTrained(false);
    }

    public Puppy() {
    }

    @Override
    public boolean feedDog() {
        System.out.println(this.getName() + " just ate " + Food.MEAT);
        this.setFed(true);
        return this.isFed();
    }
    @Override
    public void doActivity() {
        System.out.println(this.getName() + " is being trained.");
    }

    @Override
    public String toString() {
        return "Puppy " + super.toString();
    }
}
