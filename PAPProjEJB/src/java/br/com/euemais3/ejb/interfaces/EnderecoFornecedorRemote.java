package br.com.euemais3.ejb.interfaces;

import br.com.euemais3.bo.EnderecoFornecedor;
import java.util.List;

public interface EnderecoFornecedorRemote {

    public EnderecoFornecedor salvar(EnderecoFornecedor enderecoFornecedor);

    public EnderecoFornecedor consultarPorId(Long id);

    public void remover(Long id);

    public List<EnderecoFornecedor> consultarEnderecosFornecedores();
}
