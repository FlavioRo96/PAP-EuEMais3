package br.com.euemais3.ejbproj.ejb;

import br.com.euemais3.ejbproj.bo.Fornecedor;
import br.com.euemais3.ejbproj.bo.Genero;
import br.com.euemais3.ejbproj.bo.TipoConta;
import br.com.euemais3.ejbproj.dao.FornecedorDAO;
import br.com.euemais3.ejbproj.dao.GeneroDAO;
import br.com.euemais3.ejbproj.dao.TipoContaDAO;
import br.com.euemais3.ejbproj.ejb.interfaces.FornecedorRemote;
import br.com.euemais3.ejbproj.ejb.interfaces.GeneroRemote;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FornecedorEJB implements FornecedorRemote {

    @PersistenceContext(unitName = "PAPProjEJBv3PU")
    private EntityManager em;

    @Override
    public Fornecedor salvar(Fornecedor tipoConta) {
        FornecedorDAO dao = new FornecedorDAO(em);
        return dao.salvar(tipoConta);
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