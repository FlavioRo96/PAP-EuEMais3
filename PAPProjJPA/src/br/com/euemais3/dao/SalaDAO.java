package br.com.euemais3.dao;

import br.com.euemais3.model.Sala;
import javax.persistence.EntityManager;

public class SalaDAO extends DAOBase{
    
    public Sala salvar(Sala sala) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            if (sala.getId() == null) {
                entityManager.persist(sala);
            } else {
                sala = entityManager.merge(sala);
            }
            entityManager.getTransaction().commit();
        } finally {
//            entityManager.close();
        }
        return sala;
    }

    public void excluir(Long id) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();

            Sala sala = entityManager.find(Sala.class, id);
            entityManager.remove(sala);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
    
    public Sala consultarPorId(Long id) {
        EntityManager entityManager = getEntityManager();
        Sala sala = null;

        try {
            sala = entityManager.find(Sala.class, id);
        } finally {
            entityManager.close();
        }
        return sala;
    }
}
