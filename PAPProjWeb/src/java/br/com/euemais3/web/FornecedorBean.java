package br.com.euemais3.web;

import br.com.euemais3.ejbproj.bo.Fornecedor;
import br.com.euemais3.ejbproj.dao.FornecedorDAO;
import br.com.euemais3.ejbproj.ejb.interfaces.FornecedorRemote;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ManagedBean
public class FornecedorBean implements FornecedorRemote{

    @PersistenceContext(unitName = "PAPProjEJBv3PU")
    private EntityManager em;

    public FornecedorBean() {
    }

    @Override
    public Fornecedor salvar(Fornecedor fornecedor) {
        FornecedorDAO dao = new FornecedorDAO(em);
        return dao.salvar(fornecedor);
    }

    @Override
    public void remover(Long id) {
        FornecedorDAO dao = new FornecedorDAO(em);
        dao.remover(id);
    }

    @Override
    public Fornecedor consultarPorId(Long id) {
        FornecedorDAO dao = new FornecedorDAO(em);
        return dao.consultarPorId(id);
    }

    @Override
    public List<Fornecedor> consultarFornecedores() {
        FornecedorDAO dao = new FornecedorDAO(em);
        return dao.consultarFornecedores();
    }


}
