package org.serdarsenturk.console1.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static final String PERSISTENCE_UNIT_NAME = "testdb";
    private static EntityManagerFactory emf;

    public static EntityManagerFactory getEntityManagerFactory(){
        if (emf == null){
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return emf;
    }

    public static void shutdown(){
        if (emf != null){
            emf.close();
        }
    }
}