package com.peteparamonov.classes.tools;

import com.peteparamonov.classes.dogs.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Set;

public class ControllerDB {
    public static void fillDataBase(SessionFactory factory, Session session, Set<Dog> dogs){
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            dogs.forEach(session::save);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
            session.close();
        }
    }
}
