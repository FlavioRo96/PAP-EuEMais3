package br.com.euemais3.ejbproj.ejb.interfaces;

import br.com.euemais3.ejbproj.bo.Filme;
import br.com.euemais3.ejbproj.bo.Fornecedor;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface FilmeRemote {

    public Filme salvar(Filme filme);

    public Filme consultarPorId(Long id);

    public void remover(Long id);

    public List<Filme> consultarFilmes();
}
