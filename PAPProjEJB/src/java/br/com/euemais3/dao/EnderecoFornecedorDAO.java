package br.com.euemais3.dao;

import br.com.euemais3.bo.EnderecoFornecedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EnderecoFornecedorDAO {

    private EntityManager em;

    public EnderecoFornecedorDAO(EntityManager em) {
        this.em = em;
    }

    public EnderecoFornecedor salvar(EnderecoFornecedor enderecoFornecedor) {
        if (enderecoFornecedor.getId() == null) {
            em.persist(enderecoFornecedor);
        } else {
            em.merge(enderecoFornecedor);
        }
        return enderecoFornecedor;
    }

    public EnderecoFornecedor consultarPorId(Long id) {
        EnderecoFornecedor enderecoFornecedor = em.find(EnderecoFornecedor.class, id);
        return enderecoFornecedor;
    }

    public void remover(Long id) {
        EnderecoFornecedor enderecoFornecedor = em.find(EnderecoFornecedor.class, id);
        em.remove(enderecoFornecedor);
    }

    public List<EnderecoFornecedor> consultarEnderecosFornecedores() {
        Query q = em.createNamedQuery(EnderecoFornecedor.ListQueryName.consultarTodos);
        return q.getResultList();
    }
}
