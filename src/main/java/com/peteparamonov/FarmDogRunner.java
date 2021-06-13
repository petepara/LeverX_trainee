package com.peteparamonov;

import com.peteparamonov.api.Active;
import com.peteparamonov.classes.dogs.AdultDog;
import com.peteparamonov.classes.dogs.Dog;
import com.peteparamonov.classes.dogs.ElderlyDog;
import com.peteparamonov.classes.dogs.Puppy;
import com.peteparamonov.classes.tools.ControllerDB;
import com.peteparamonov.classes.tools.DayRepresentation;
import com.peteparamonov.classes.tools.FarmDog;
import com.peteparamonov.classes.workers.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class FarmDogRunner {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Scanner inputData = new Scanner(System.in);
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Dog.class)
                .addAnnotatedClass(AdultDog.class)
                .addAnnotatedClass(ElderlyDog.class)
                .addAnnotatedClass(Puppy.class)
                .buildSessionFactory();
        Session session = null;
        Set <Dog> dogs = FarmDog.createFarmDog(random, inputData);

        System.out.println("Enter name of the person who will cure our beautiful dogs:");
        Veterinary veterinary = new Veterinary(inputData.nextLine());
        Cleaner cleaner = new Cleaner("Janitor");

        FarmDog.printInfoAboutDogs(dogs);
        ControllerDB.fillDataBase(factory, session, dogs);
        Trainer coach = new Trainer("Dwayne Jones", dogs);
        DayRepresentation.representDayInFarm(dogs, veterinary, cleaner, coach);

    }
}
