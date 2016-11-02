package br.com.euemais3.ejbproj.ejb.interfaces;

import br.com.euemais3.ejbproj.bo.Endereco;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface EnderecoRemote {

    public Endereco salvar(Endereco endereco);

    public Endereco consultarPorId(Long id);

    public void remover(Long id);

    public List<Endereco> consultarEnderecos();

}
