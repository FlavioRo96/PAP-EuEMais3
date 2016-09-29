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

    public Usuario consultarPorId(Long id) {
        Usuario usuario = em.find(Usuario.class, id);
        return usuario;
    }

    public void remover(Long id) {
        Usuario usuario = em.find(Usuario.class, id);
        em.remove(usuario);
    }

    public List<Usuario> consultarUsuarios() {
        Query q = em.createNamedQuery(Usuario.ListQueryName.consultarTodos);
        return q.getResultList();
    }

}
