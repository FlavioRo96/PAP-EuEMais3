package br.com.euemais3.ejb;

import br.com.euemais3.bo.Fornecedor;
import br.com.euemais3.dao.FornecedorDAO;
import br.com.euemais3.ejb.interfaces.FornecedorRemote;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class FornecedorEJB implements FornecedorRemote{
    @PersistenceContext(unitName = "PAPProjPU")
    private EntityManager em;
    
    @Override
    public Fornecedor salvar(Fornecedor fornecedor) {
        FornecedorDAO dao = new FornecedorDAO(em);
        return dao.salvar(fornecedor);
    }

    @Override
    public Fornecedor consultarPorId(Long id) {
        FornecedorDAO dao = new FornecedorDAO(em);
        return dao.consultarPorId(id);
    }

    @Override
    public void remover(Long id) {
        FornecedorDAO dao = new FornecedorDAO(em);
        dao.remover(id);
    }

    @Override
    public List<Fornecedor> consultarFornecedores() {
        FornecedorDAO dao = new FornecedorDAO(em);
        return dao.consultarFornecedores();
    }
}
