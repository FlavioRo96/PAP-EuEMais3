package br.com.euemais3.dao;

import br.com.euemais3.model.Fornecedor;
import javax.persistence.EntityManager;

public class FornecedorDAO extends DAOBase{
    
    public Fornecedor salvar(Fornecedor fornecedor) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            if (fornecedor.getId() == null) {
                entityManager.persist(fornecedor);
            } else {
                fornecedor = entityManager.merge(fornecedor);
            }
            entityManager.getTransaction().commit();
        } finally {
//            entityManager.close();
        }
        return fornecedor;
    }

    public void excluir(Long id) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();

            Fornecedor fornecedor = entityManager.find(Fornecedor.class, id);
            entityManager.remove(fornecedor);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public Fornecedor consultarPorId(Long id) {
        EntityManager entityManager = getEntityManager();
        Fornecedor fornecedor = null;

        try {
            fornecedor = entityManager.find(Fornecedor.class, id);
        } finally {
            entityManager.close();
        }
        return fornecedor;
    }
}
