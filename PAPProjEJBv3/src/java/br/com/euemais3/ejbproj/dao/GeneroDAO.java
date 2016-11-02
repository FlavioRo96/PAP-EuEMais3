package br.com.euemais3.ejbproj.dao;

import br.com.euemais3.ejbproj.bo.Genero;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GeneroDAO {

    private EntityManager em;

    public GeneroDAO(EntityManager em) {
        this.em = em;
    }

    public Genero salvar(Genero genero) {
        if (genero.getId() == null) {
            em.persist(genero);
        } else {
            em.merge(genero);
        }
        return genero;
    }
    
    public Genero consultarPorId(Long id) {
        return em.find(Genero.class, id);
    }

    public void remover(Long id) {
        Genero genero = em.find(Genero.class, id);
        em.remove(genero);
    }

    public List<Genero> consultarGeneros() {
        Query q = em.createNamedQuery("consultarTodos.Genero");
        return q.getResultList();
    }
}
