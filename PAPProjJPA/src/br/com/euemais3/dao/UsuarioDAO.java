package br.com.euemais3.dao;

import br.com.euemais3.model.Usuario;
import javax.persistence.EntityManager;

public class UsuarioDAO extends DAOBase{


    public Usuario salvar(Usuario usuario) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            if (usuario.getId() == null) {
                entityManager.persist(usuario);
            } else {
                usuario = entityManager.merge(usuario);
            }
            entityManager.getTransaction().commit();
        } finally {
//            entityManager.close();
        }
        return usuario;
    }
    
    
    public void excluir (Long id)
    {
        EntityManager entityManager = getEntityManager();
        
        try{
            entityManager.getTransaction().begin();
            
            Usuario usuario = entityManager.find(Usuario.class, id);
            entityManager.remove(usuario);
            
            entityManager.getTransaction().commit();
        }
        finally{
            entityManager.close();
        }
    }
    
    public Usuario consultarPorId(Long id)
    {
        EntityManager entityManager = getEntityManager();
        Usuario usuario = null;
        
        try{
            usuario = entityManager.find(Usuario.class, id);
        }
        finally{
            entityManager.close();
        }
        return usuario;
    }
}
