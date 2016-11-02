package br.com.euemais3.ejbproj.ejb.interfaces;

import br.com.euemais3.ejbproj.bo.Genero;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface GeneroRemote {

    public Genero salvar(Genero genero);

    public Genero consultarPorId(Long id);

    public void remover(Long id);

    public List<Genero> consultarGeneros();
}
