package br.com.euemais.web;

import br.com.euemais3.ejbproj.bo.Fornecedor;
import br.com.euemais3.ejbproj.ejb.interfaces.FornecedorRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class FornecedorBean {

    private Fornecedor fornecedor;
    @EJB
    private FornecedorRemote ejb;

    public FornecedorBean(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Fornecedor salvar() {
        Fornecedor f = ejb.salvar(fornecedor);
        fornecedor = new Fornecedor();
        return f;
    }

    public void remover() {
        ejb.remover(fornecedor.getId());
        fornecedor = new Fornecedor();
    }

    public Fornecedor consultarPorId() {
        return ejb.consultarPorId(fornecedor.getId());
    }

    public List<Fornecedor> consultarFornecedores() {
        return ejb.consultarFornecedores();
    }
}
