package br.com.euemais3.ejbproj.dao;

import br.com.euemais3.ejbproj.bo.Sala;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class SalaDAO {

    private EntityManager em;

    public SalaDAO(EntityManager em) {
        this.em = em;
    }

    public Sala salvar(Sala sala) {
        if (sala.getId() == null) {
            em.persist(sala);
        } else {
            em.merge(sala);
        }
        return sala;
    }

    public Sala consultarPorId(Long id) {
        Sala sala = em.find(Sala.class, id);
        return sala;
    }

    public void remover(Long id) {
        Sala sala = em.find(Sala.class, id);
        em.remove(sala);
    }

//    public List<Sala> consultarSalas() {
//        Query q = em.createNamedQuery(Sala.ListQueryName.consultarTodos);
//        return q.getResultList();
//    }
}
