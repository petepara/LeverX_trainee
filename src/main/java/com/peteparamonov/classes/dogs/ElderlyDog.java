package com.peteparamonov.classes.dogs;

import javax.persistence.Entity;

@Entity
public class ElderlyDog extends Dog {

    public ElderlyDog(int age, String name, boolean isHealthy) {
        super(age, name, isHealthy);
        this.setTrained(true);
    }

    public ElderlyDog() {
    }

    @Override
    public boolean feedDog() {
        System.out.println(this.getName() + " just ate " + Food.PORRIDGE);
        this.setFed(true);
        return this.isFed();
    }
    @Override
    public void doActivity() {
        System.out.println(this.getName() + " is farting.");
    }

    @Override
    public String toString() {
        return "Old dog " + super.toString();
    }
}
