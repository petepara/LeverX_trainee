package com.peteparamonov.classes.tools;

import com.peteparamonov.api.Active;
import com.peteparamonov.classes.dogs.Dog;
import com.peteparamonov.classes.workers.Cleaner;
import com.peteparamonov.classes.workers.Trainer;
import com.peteparamonov.classes.workers.Veterinary;

import java.util.Set;

public class DayRepresentation {
    public static void representDayInFarm(Set<Dog> dogs, Veterinary veterinary, Cleaner cleaner, Trainer coach) throws InterruptedException {
        System.out.println("------------");
        Thread.sleep(2000);
        System.out.println("It's time to have breakfast for our cute dogs");
        Thread.sleep(3000);
        dogs.forEach(Dog::feedDog);
        System.out.println("------------");
        Thread.sleep(2000);
        System.out.println("It's time to do something!");
        veterinary.doActivity();
        System.out.println("------------");
        veterinary.printResultOfExamining(dogs);
        System.out.println("------------");
        Thread.sleep(1000);

        dogs.stream().filter(dog -> !dog.isHealthy()).forEach(veterinary::cureDog);
        System.out.println("------------");
        cleaner.doActivity();
        System.out.println("------------");
        coach.doActivity();
        System.out.println("------------");
        dogs.forEach(Active::doActivity);
        System.out.println("------------");
        Thread.sleep(4000);

        System.out.println("It's time to have dinner for our cute dogs");
        dogs.forEach(Dog::feedDog);
        System.out.println("------------");
        System.out.println("It was a good day!");
    }
}
