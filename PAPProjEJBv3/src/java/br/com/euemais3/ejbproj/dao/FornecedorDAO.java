package br.com.euemais3.ejbproj.dao;

import br.com.euemais3.ejbproj.bo.Fornecedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class FornecedorDAO {

    private EntityManager em;

    public FornecedorDAO(EntityManager em) {
        this.em = em;
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        if (fornecedor.getId() == null) {
            em.persist(fornecedor);
        } else {
            em.merge(fornecedor);
        }
        return fornecedor;
    }

    public Fornecedor consultarPorId(Long id) {
        Fornecedor fornecedor = em.find(Fornecedor.class, id);
        return fornecedor;
    }

    public void remover(Long id) {
        Fornecedor fornecedor = em.find(Fornecedor.class, id);
        em.remove(fornecedor);
    }

    public List<Fornecedor> consultarFornecedores() {
        Query q = em.createNamedQuery("consultarTodos.Fornecedor");
        return q.getResultList();
    }

}
