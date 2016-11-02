package br.com.euemais3.ejb.interfaces;

import br.com.euemais3.bo.Fornecedor;
import java.util.List;

public interface FornecedorRemote {

    public Fornecedor salvar(Fornecedor fornecedor);

    public Fornecedor consultarPorId(Long id);

    public void remover(Long id);

    public List<Fornecedor> consultarFornecedores();
}
