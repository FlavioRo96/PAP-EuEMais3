package br.com.euemais3.ejbproj.dao;

import br.com.euemais3.ejbproj.bo.Endereco;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EnderecoDAO {

    private EntityManager em;

    public EnderecoDAO(EntityManager em) {
        this.em = em;
    }

    public Endereco salvar(Endereco endereco) {
        if (endereco.getId() == null) {
            em.persist(endereco);
        } else {
            em.merge(endereco);
        }
        return endereco;
    }

    public Endereco consultarPorId(Long id) {
        Endereco endereco = em.find(Endereco.class, id);
        return endereco;
    }

    public void remover(Long id) {
        Endereco endereco = em.find(Endereco.class, id);
        em.remove(endereco);
    }

    public List<Endereco> consultarSalas() {
        Query q = em.createNamedQuery("consultarTodos.Endereco");
        return q.getResultList();
    }
}
