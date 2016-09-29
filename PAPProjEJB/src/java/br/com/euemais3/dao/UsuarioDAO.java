package br.com.euemais3.dao;

import br.com.euemais3.bo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UsuarioDAO {

    private EntityManager em;

    public UsuarioDAO(EntityManager em) {
        this.em = em;
    }

    public Usuario salvar(Usuario usuario) {
        if (usuario.getId() == null) {
            em.persist(usuario);
        } else {
            em.merge(usuario);
        }
        return usuario;
    }

    public Usuario consultarPorId(Long id) {
        return em.find(Usuario.class, id);
    }

    public void remover(Long id) {
        Usuario usuario = em.find(Usuario.class, id);
        em.remove(usuario);
    }

    public List<Usuario> consultarMedalhas() {
        Query q = em.createNamedQuery(Usuario.ListQueryName.consultarTodos);
        return q.getResultList();
    }
}
