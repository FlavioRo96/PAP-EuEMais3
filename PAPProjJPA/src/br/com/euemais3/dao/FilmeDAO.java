package br.com.euemais3.dao;

import br.com.euemais3.model.Filme;
import javax.persistence.EntityManager;

public class FilmeDAO extends DAOBase{

    public Filme salvar(Filme filme) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            if (filme.getId() == null) {
                entityManager.persist(filme);
            } else {
                filme = entityManager.merge(filme);
            }
            entityManager.getTransaction().commit();
        } finally {
//            entityManager.close();
        }
        return filme;
    }

    public void excluir(Long id) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();

            Filme usuario = entityManager.find(Filme.class, id);
            entityManager.remove(usuario);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
    
    public Filme consultarPorId(Long id) {
        EntityManager entityManager = getEntityManager();
        Filme usuario = null;

        try {
            usuario = entityManager.find(Filme.class, id);
        } finally {
            entityManager.close();
        }
        return usuario;
    }

}