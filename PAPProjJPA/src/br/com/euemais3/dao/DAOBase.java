package br.com.euemais3.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAOBase {
    
    public EntityManager getEntityManager() {
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;

        try {
            factory = Persistence.createEntityManagerFactory("PAPProjJPAPU");
            entityManager = factory.createEntityManager();

        } finally {
            //factory.close();
        }
        return entityManager;
    }
}
