package br.com.euemais3.dao;

import br.com.euemais3.model.EnderecoUsuario;
import javax.persistence.EntityManager;

public class EnderecoUsuarioDAO extends DAOBase{
    
    public EnderecoUsuario salvar(EnderecoUsuario enderecoUsuario) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            if (enderecoUsuario.getId() == null) {
                entityManager.persist(enderecoUsuario);
            } else {
                enderecoUsuario = entityManager.merge(enderecoUsuario);
            }
            entityManager.getTransaction().commit();
        } finally {
//            entityManager.close();
        }
        return enderecoUsuario;
    }

    public void excluir(Long id) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();

            EnderecoUsuario enderecoUsuario = entityManager.find(EnderecoUsuario.class, id);
            entityManager.remove(enderecoUsuario);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
    
    public EnderecoUsuario consultarPorId(Long id) {
        EntityManager entityManager = getEntityManager();
        EnderecoUsuario enderecoUsuario = null;

        try {
            enderecoUsuario = entityManager.find(EnderecoUsuario.class, id);
        } finally {
            entityManager.close();
        }
        return enderecoUsuario;
    }
}
