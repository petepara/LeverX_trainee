package com.peteparamonov.classes.tools;

import com.peteparamonov.classes.dogs.AdultDog;
import com.peteparamonov.classes.dogs.Dog;
import com.peteparamonov.classes.dogs.ElderlyDog;
import com.peteparamonov.classes.dogs.Puppy;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class FarmDog {
    /**
     * Method creates a set of dogs and fills it by bogs of different categories.
     * In method you should give names to dogs. Names should be unique.
     * @param random - parameter which gives random numbers which used for sizing
     *                 dog farm and for age of dogs determination
     * @param inputData - parameter which used for inputting names
     * @return set parameterized by class Dog
     */
    public static Set <Dog> createFarmDog(Random random, Scanner inputData){
        final int NUMBER_OF_DOGS = random.nextInt(11) + 1;
        int ageDog;
        String nameDog;
        boolean health;
        Set <Dog> dogs = new HashSet<>(NUMBER_OF_DOGS);
        System.out.println("Enter unique names for " + NUMBER_OF_DOGS + " dog in our farm");
        for (int i = 0; i < NUMBER_OF_DOGS; i++) {
            ageDog = random.nextInt(15)+1;
            nameDog = inputData.nextLine();
            health = random.nextBoolean();
            if(ageDog < 2){
                dogs.add(new Puppy(ageDog, nameDog, health));
            } else if (ageDog <= 8) {
                dogs.add(new AdultDog(ageDog, nameDog, health));
            } else {
                dogs.add(new ElderlyDog(ageDog, nameDog, health));
            }
        }
        if(dogs.size()< NUMBER_OF_DOGS){
            System.err.println("Names of dogs should be unique...Need to add " + (NUMBER_OF_DOGS - dogs.size()) + " name(s)...");
            do{
                ageDog = random.nextInt(15);
                nameDog = inputData.nextLine();
                health = random.nextBoolean();
                if(ageDog < 2){
                    dogs.add(new Puppy(ageDog, nameDog, health));
                } else if (ageDog <= 8) {
                    dogs.add(new AdultDog(ageDog, nameDog, health));
                } else {
                    dogs.add(new ElderlyDog(ageDog, nameDog, health));
                }
            }while (dogs.size()!= NUMBER_OF_DOGS);
        }
        return dogs;
    }

    /**
     * Method prints information about number of dogs by age
     * in farm of dogs
     * @param dogs the reference set in which count dogs.
     */
    public static void printInfoAboutDogs(Set <Dog> dogs){
        System.out.println("In our dog farm we have: ");
        System.out.println(dogs.stream().filter(dog -> dog.getClass() == Puppy.class).count() + " puppy ");
        System.out.println(dogs.stream().filter(dog -> dog.getClass() == AdultDog.class).count() + " adult dog");
        System.out.println(dogs.stream().filter(dog -> dog.getClass() == ElderlyDog.class).count() + " old dog");
    }
}
