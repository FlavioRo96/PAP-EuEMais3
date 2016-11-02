package br.com.euemais3.ejbproj.ejb.interfaces;

import br.com.euemais3.ejbproj.bo.TipoConta;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface TipoContaRemote {

    public TipoConta salvar(TipoConta tipoConta);

    public TipoConta consultarPorId(Long id);

    public void remover(Long id);

    public List<TipoConta> consultarTiposContas();
}
