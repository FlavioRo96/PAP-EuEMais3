package br.com.euemais3.ejbproj.ejb.interfaces;

import br.com.euemais3.ejbproj.bo.Fornecedor;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface FornecedorRemote {

    public Fornecedor salvar(Fornecedor fornecedor);

    public Fornecedor consultarPorId(Long id);

    public void remover(Long id);

    public List<Fornecedor> consultarFornecedores();
}
