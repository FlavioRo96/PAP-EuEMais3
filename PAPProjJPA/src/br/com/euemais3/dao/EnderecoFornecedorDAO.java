package br.com.euemais3.dao;

import br.com.euemais3.model.EnderecoFornecedor;
import javax.persistence.EntityManager;

public class EnderecoFornecedorDAO extends DAOBase{
    
    public EnderecoFornecedor salvar(EnderecoFornecedor enderecoFornecedor) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            if (enderecoFornecedor.getId() == null) {
                entityManager.persist(enderecoFornecedor);
            } else {
                enderecoFornecedor = entityManager.merge(enderecoFornecedor);
            }
            entityManager.getTransaction().commit();
        } finally {
//            entityManager.close();
        }
        return enderecoFornecedor;
    }

    public void excluir(Long id) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();

            EnderecoFornecedor enderecoFornecedor = entityManager.find(EnderecoFornecedor.class, id);
            entityManager.remove(enderecoFornecedor);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
    
    public EnderecoFornecedor consultarPorId(Long id) {
        EntityManager entityManager = getEntityManager();
        EnderecoFornecedor enderecoFornecedor = null;

        try {
            enderecoFornecedor = entityManager.find(EnderecoFornecedor.class, id);
        } finally {
            entityManager.close();
        }
        return enderecoFornecedor;
    }
}
