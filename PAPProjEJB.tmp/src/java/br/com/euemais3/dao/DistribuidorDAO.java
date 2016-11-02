package br.com.euemais3.dao;

import br.com.euemais3.bo.Distribuidor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DistribuidorDAO {
    
    private EntityManager em;

    public DistribuidorDAO(EntityManager em) {
        this.em = em;
    }
    
    public Distribuidor salvar(Distribuidor distribuidor)
    {
        if (distribuidor.getId() == null)
        {
            em.persist(distribuidor);
        }
        else
        {
            em.merge(distribuidor);
        }
        return distribuidor;
    }
    
    public Distribuidor consultarPorId(Long id)
    {
        Distribuidor distribuidor = em.find(Distribuidor.class, id);
        return distribuidor;
    }
    
    public void remover(Long id)
    {
        Distribuidor distribuidor = em.find(Distribuidor.class, id);
        em.remove(distribuidor);
    }
    
    public List<Distribuidor> consultarDistribuidores()
    {
        Query q = em.createNamedQuery(Distribuidor.ListQueryName.consultarTodos);
        return q.getResultList();
    }
}
