package br.com.euemais3.ejb.interfaces;

import br.com.euemais3.bo.EnderecoUsuario;
import java.util.List;

public interface EnderecoUsuarioRemote {

    public EnderecoUsuario salvar(EnderecoUsuario enderecoUsuario);

    public EnderecoUsuario consultarPorId(Long id);

    public void remover(Long id);

    public List<EnderecoUsuario> consultarEnderecosUsuarios();
}
