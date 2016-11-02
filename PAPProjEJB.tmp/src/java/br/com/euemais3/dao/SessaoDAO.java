package br.com.euemais3.dao;

import br.com.euemais3.bo.Sessao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class SessaoDAO {

    private EntityManager em;

    public SessaoDAO(EntityManager em) {
        this.em = em;
    }

    public Sessao salvar(Sessao sessao) {
        if (sessao.getId() == null) {
            em.persist(sessao);
        } else {
            em.merge(sessao);
        }
        return sessao;
    }

    public Sessao consultarPorId(Long id) {
        Sessao sessao = em.find(Sessao.class, id);
        return sessao;
    }

    public void remover(Long id) {
        Sessao sessao = em.find(Sessao.class, id);
        em.remove(id);
    }

    public List<Sessao> consultarSessoes() {
        Query q = em.createNamedQuery(Sessao.ListQueryName.consultarTodos);
        return q.getResultList();
    }

}
