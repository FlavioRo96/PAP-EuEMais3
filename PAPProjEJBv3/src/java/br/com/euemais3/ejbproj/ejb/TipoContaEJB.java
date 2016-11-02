package br.com.euemais3.ejbproj.ejb;

import br.com.euemais3.ejbproj.bo.TipoConta;
import br.com.euemais3.ejbproj.dao.TipoContaDAO;
import br.com.euemais3.ejbproj.ejb.interfaces.TipoContaRemote;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TipoContaEJB implements TipoContaRemote {

    @PersistenceContext(unitName = "PAPProjEJBv3PU")
    private EntityManager em;

    @Override
    public TipoConta salvar(TipoConta tipoConta) {
        TipoContaDAO dao = new TipoContaDAO(em);
        return dao.salvar(tipoConta);
    }

    @Override
    public TipoConta consultarPorId(Long id) {
        TipoContaDAO dao = new TipoContaDAO(em);
        return dao.consultarPorId(id);
    }

    @Override
    public void remover(Long id) {
        TipoContaDAO dao = new TipoContaDAO(em);
        dao.remover(id);
    }

    @Override
    public List<TipoConta> consultarTiposContas() {
        TipoContaDAO dao = new TipoContaDAO(em);
        return dao.consultarTipoContas();
    }
}