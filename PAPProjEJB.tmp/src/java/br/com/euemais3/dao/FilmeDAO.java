package br.com.euemais3.dao;

import br.com.euemais3.bo.Filme;
import br.com.euemais3.bo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class FilmeDAO {

    private EntityManager em;

    public FilmeDAO(EntityManager em) {
        this.em = em;
    }

    public Filme salvar(Filme filme) {
        if (filme.getId() == null) {
            em.persist(filme);
        } else {
            em.merge(filme);
        }
        return filme;
    }

    public Filme consultarPorId(Long id) {
        Filme filme = em.find(Filme.class, id);
        return filme;
    }

    public void remover(Long id) {
        Filme filme = em.find(Filme.class, id);
        em.remove(filme);
    }

    public List<Filme> consultarUsuarios() {
        Query q = em.createNamedQuery("consultarTodos.Usuario");
        return q.getResultList();
    }

}
