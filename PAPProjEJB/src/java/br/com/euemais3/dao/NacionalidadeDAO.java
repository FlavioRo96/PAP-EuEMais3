package br.com.euemais3.dao;

import br.com.euemais3.bo.Nacionalidade;
import javax.persistence.EntityManager;

public class NacionalidadeDAO {

    private EntityManager em;

    public NacionalidadeDAO(EntityManager em) {
        this.em = em;
    }

    public Nacionalidade salvar(Nacionalidade nacionalidade) {
        if (nacionalidade.getId() == null) {
            this.em.persist(nacionalidade);
        } else {
            this.em.merge(nacionalidade);
        }
        return nacionalidade;
    }
    
    

}
