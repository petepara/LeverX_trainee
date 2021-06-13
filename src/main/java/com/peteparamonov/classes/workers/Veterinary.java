package com.peteparamonov.classes.workers;

import com.peteparamonov.classes.dogs.Dog;

import java.util.Set;

public class Veterinary extends Worker {

    public Veterinary(String name) {
        super(name);
    }

    @Override
    public void doActivity(){
        System.out.println("Veterinary " + this.getName() + " is examining dogs.");
    }

    public void printResultOfExamining(Set<Dog> setOfDogs){
        for (Dog dog: setOfDogs) {
            if (dog.isHealthy()) {
                System.out.println(dog.getName() + " is healthy.");
            } else {
                System.out.println(dog.getName() + " is need to be healed.");
            }
        }
    }
    public void cureDog(Dog dog) {
        dog.setHealthy(true);
        System.out.println(this.getName() + " cured " + dog.getName() + ".");
    }
}
