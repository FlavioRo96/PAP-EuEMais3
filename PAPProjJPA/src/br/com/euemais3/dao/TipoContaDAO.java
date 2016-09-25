package br.com.euemais3.dao;

import br.com.euemais3.model.TipoConta;
import javax.persistence.EntityManager;

public class TipoContaDAO extends DAOBase {
    
    public TipoConta salvar(TipoConta tipoConta) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            if (tipoConta.getId() == null) {
                entityManager.persist(tipoConta);
            } else {
                tipoConta = entityManager.merge(tipoConta);
            }
            entityManager.getTransaction().commit();
        } finally {
//            entityManager.close();
        }
        return tipoConta;
    }

    public void excluir(Long id) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();

            TipoConta tipoConta = entityManager.find(TipoConta.class, id);
            entityManager.remove(tipoConta);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public TipoConta consultarPorId(Long id) {
        EntityManager entityManager = getEntityManager();
        TipoConta tipoConta = null;

        try {
            tipoConta = entityManager.find(TipoConta.class, id);
        } finally {
            entityManager.close();
        }
        return tipoConta;
    }
}