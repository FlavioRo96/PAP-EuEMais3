package br.com.euemais3.dao;

import br.com.euemais3.bo.EnderecoUsuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EnderecoUsuarioDAO {

    private EntityManager em;

    public EnderecoUsuarioDAO(EntityManager em) {
        this.em = em;
    }

    public EnderecoUsuario salvar(EnderecoUsuario enderecoUsuario) {
        if (enderecoUsuario.getId() == null) {
            em.persist(enderecoUsuario);
        } else {
            em.merge(enderecoUsuario);
        }
        return enderecoUsuario;
    }

    public EnderecoUsuario consultarPorId(Long id) {
        EnderecoUsuario enderecoUsuario = em.find(EnderecoUsuario.class, id);
        return enderecoUsuario;
    }

    public void remover(Long id) {
        EnderecoUsuario enderecoUsuario = em.find(EnderecoUsuario.class, id);
        em.remove(enderecoUsuario);
    }

    public List<EnderecoUsuario> consultarEnderecosUsuarios() {
        Query q = em.createNamedQuery(EnderecoUsuario.ListQueryName.consultarTodos);
        return q.getResultList();
    }
}
