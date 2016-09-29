package br.com.euemais3.dao;

import br.com.euemais3.bo.TipoConta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TipoContaDAO {

    private EntityManager em;

    public TipoContaDAO(EntityManager em) {
        this.em = em;
    }

    public TipoConta salvar(TipoConta tipoConta) {
        if (tipoConta.getId() == null) {
            em.persist(tipoConta);
        } else {
            em.merge(tipoConta);
        }
        return tipoConta;
    }

    public TipoConta consultarPorId(Long id) {
        TipoConta tipoConta = em.find(TipoConta.class, id);
        return tipoConta;
    }

    public void remover(Long id) {
        TipoConta tipoConta = em.find(TipoConta.class, id);
        em.remove(id);
    }

    public List<TipoConta> consultarTipoContas() {
        Query q = em.createNamedQuery(TipoConta.ListQueryName.consultarTodos);
        return q.getResultList();
    }

}
