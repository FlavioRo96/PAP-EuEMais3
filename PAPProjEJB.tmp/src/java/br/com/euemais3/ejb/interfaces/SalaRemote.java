package br.com.euemais3.ejb.interfaces;

import br.com.euemais3.bo.Sala;
import java.util.List;

public interface SalaRemote {

    public Sala salvar(Sala sala);

    public Sala consultarPorId(Long id);

    public void remover(Long id);

    public List<Sala> consultarSalas();
}
