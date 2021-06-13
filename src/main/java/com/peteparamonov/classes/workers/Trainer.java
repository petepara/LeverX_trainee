package com.peteparamonov.classes.workers;

import com.peteparamonov.classes.dogs.Dog;

import java.util.List;
import java.util.Set;

public class Trainer extends Worker {
    Set <Dog> dogsToTrain;
    public Trainer(String name, Set<Dog> dogsToTrain) {
        super(name);
        this.dogsToTrain = dogsToTrain;
    }

    @Override
    public void doActivity(){
        dogsToTrain.stream().filter(dog->dog.getAge()<2).forEach(dog -> System.out.println(this.getName() + " trains " + dog.getName() + "."));
    }
    
}
