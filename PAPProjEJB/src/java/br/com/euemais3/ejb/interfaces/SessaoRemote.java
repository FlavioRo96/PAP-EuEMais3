package br.com.euemais3.ejb.interfaces;

import br.com.euemais3.bo.Sessao;
import java.util.List;

public interface SessaoRemote {

    public Sessao salvar(Sessao sessao);

    public Sessao consultarPorId(Long id);

    public void remover(Long id);

    public List<Sessao> consultarSessoes();
}
