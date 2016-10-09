package br.com.euemais3.dao;

import br.com.euemais3.bo.Elenco;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ElencoDAO {
    
    private EntityManager em;

    public ElencoDAO(EntityManager em) {
        this.em = em;
    }
    
    public Elenco salvar(Elenco elenco)
    {
        if (elenco.getId() == null)
        {
            em.persist(elenco);
        }
        else
        {
            em.merge(elenco);
        }
        
        return elenco;
    }
    
    public Elenco consultarPorId(Long id){
        Elenco elenco = em.find(Elenco.class, id);
        return elenco;
    }
    
    public void remover(Long id){
        Elenco elenco = em.find(Elenco.class, id);
        em.remove(elenco);
    }
    
    public List<Elenco> consultarElencos(){
        Query q = em.createNamedQuery(Elenco.ListQueryName.consultarTodos);
        return q.getResultList();
    }
}
