package br.com.euemais3.dao;

import br.com.euemais3.model.Sessao;
import javax.persistence.EntityManager;

public class SessaoDAO extends DAOBase{
    
    public Sessao salvar(Sessao sessao) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            if (sessao.getId() == null) {
                entityManager.persist(sessao);
            } else {
                sessao = entityManager.merge(sessao);
            }
            entityManager.getTransaction().commit();
        } finally {
//            entityManager.close();
        }
        return sessao;
    }

    public void excluir(Long id) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();

            Sessao sessao = entityManager.find(Sessao.class, id);
            entityManager.remove(sessao);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
    
    public Sessao consultarPorId(Long id) {
        EntityManager entityManager = getEntityManager();
        Sessao sessao = null;

        try {
            sessao = entityManager.find(Sessao.class, id);
        } finally {
            entityManager.close();
        }
        return sessao;
    }
}
