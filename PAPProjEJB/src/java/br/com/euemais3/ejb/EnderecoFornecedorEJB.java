package br.com.euemais3.ejb;

import br.com.euemais3.bo.EnderecoFornecedor;
import br.com.euemais3.dao.EnderecoFornecedorDAO;
import br.com.euemais3.ejb.interfaces.EnderecoFornecedorRemote;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EnderecoFornecedorEJB implements EnderecoFornecedorRemote{
    @PersistenceContext(unitName = "PAPProjPU")
    private EntityManager em;

    @Override
    public EnderecoFornecedor salvar(EnderecoFornecedor enderecoFornecedor) {
        EnderecoFornecedorDAO dao = new EnderecoFornecedorDAO(em);
        return dao.salvar(enderecoFornecedor);
    }

    @Override
    public EnderecoFornecedor consultarPorId(Long id) {
        EnderecoFornecedorDAO dao = new EnderecoFornecedorDAO(em);
        return dao.consultarPorId(id);
    }

    @Override
    public void remover(Long id) {
        EnderecoFornecedorDAO dao = new EnderecoFornecedorDAO(em);
        dao.remover(id);
    }

    @Override
    public List<EnderecoFornecedor> consultarEnderecosFornecedores() {
        EnderecoFornecedorDAO dao = new EnderecoFornecedorDAO(em);
        return dao.consultarEnderecosFornecedores();
    }
}
