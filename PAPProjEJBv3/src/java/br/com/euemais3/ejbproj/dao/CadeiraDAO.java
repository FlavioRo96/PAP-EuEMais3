package br.com.euemais3.ejbproj.dao;

import br.com.euemais3.ejbproj.bo.Cadeira;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CadeiraDAO {
    
    private EntityManager em;

    public CadeiraDAO(EntityManager em) {
        this.em = em;
    }
    
    public Cadeira salvar(Cadeira cadeira){
        if (cadeira.getId() == null)
        {
            em.persist(cadeira);
        }
        else
        {
            em.merge(cadeira);
        }
        return cadeira;
    }
    
    public Cadeira consultarPorId(Long id)
    {
        Cadeira cadeira = em.find(Cadeira.class, id);
        return cadeira;
    }
    
    public void remover (Long id)
    {
        Cadeira cadeira = em.find(Cadeira.class, id);
        em.remove(cadeira);
    }
    
    public List<Cadeira> consultarCadeiras()
    {
        Query q = em.createNamedQuery(Cadeira.ListQueryName.consultarTodos);
        return q.getResultList();
    }
    
}
