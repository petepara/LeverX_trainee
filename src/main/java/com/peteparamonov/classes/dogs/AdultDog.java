package com.peteparamonov.classes.dogs;

import javax.persistence.Entity;

@Entity
public class AdultDog extends Dog {

    public AdultDog(int age, String name, boolean isHealthy) {
        super(age, name, isHealthy);
        this.setTrained(true);
    }

    public AdultDog() {
    }

    @Override
    public boolean feedDog() {
        System.out.println(this.getName() + " just ate " + Food.MEAT + " and " + Food.BONES);
        this.setFed(true);
        return this.isFed();
    }
    @Override
    public void doActivity() {
        System.out.println(this.getName() + " is working (searching for drugs).");
    }

    @Override
    public String toString() {
        return "AdultDog " + super.toString();
    }
}
