package br.com.euemais3.ejb;

import br.com.euemais3.bo.Sessao;
import br.com.euemais3.dao.SessaoDAO;
import br.com.euemais3.ejb.interfaces.SessaoRemote;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SessaoEJB implements SessaoRemote{
    @PersistenceContext(unitName = "PAPProjPU")
    private EntityManager em;
    
    @Override
    public Sessao salvar(Sessao sessao) {
        SessaoDAO dao = new SessaoDAO(em);
        return dao.salvar(sessao);
    }

    @Override
    public Sessao consultarPorId(Long id) {
        SessaoDAO dao = new SessaoDAO(em);
        return dao.consultarPorId(id);
    }

    @Override
    public void remover(Long id) {
        SessaoDAO dao = new SessaoDAO(em);
        dao.remover(id);
    }

    @Override
    public List<Sessao> consultarSessoes() {
        SessaoDAO dao = new SessaoDAO(em);
        return dao.consultarSessoes();
    }   
}