package br.com.euemais3.ejb.interfaces;

import br.com.euemais3.bo.Filme;
import java.util.List;

public interface FilmeRemote {

    public Filme salvar(Filme filme);

    public Filme consultarPorId(Long id);

    public void remover(Long id);

    public List<Filme> consultarFilmes();
}
