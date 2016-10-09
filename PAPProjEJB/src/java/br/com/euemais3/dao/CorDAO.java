package br.com.euemais3.dao;

import br.com.euemais3.bo.Cor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CorDAO {
    
    private EntityManager em;

    public CorDAO(EntityManager em) {
        this.em = em;
    }
    
    public Cor salvar(Cor cor)
    {
        if (cor.getId() == null)
        {
            em.persist(cor);
        }
        else
        {
            em.merge(cor);
        }
        return cor;
    }
    
    public Cor consultarPorId(Long id)
    {
        Cor cor = em.find(Cor.class, id);
        return cor;
    }
    
    public void remover(Long id)
    {
        Cor cor = em.find(Cor.class, id);
        em.remove(cor);
    }
    
    public List<Cor> consultarCores(){
        Query q = em.createNamedQuery(Cor.ListQueryName.consultarTodos);
        return q.getResultList();
    }
}