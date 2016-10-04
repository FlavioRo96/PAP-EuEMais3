package br.com.euemais3.ejb;

import br.com.euemais3.bo.Sala;
import br.com.euemais3.dao.SalaDAO;
import br.com.euemais3.ejb.interfaces.SalaRemote;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SalaEJB implements SalaRemote{
    @PersistenceContext(unitName = "PAPProjPU")
    private EntityManager em;
    
    @Override
    public Sala salvar(Sala sala) {
        SalaDAO dao = new SalaDAO(em);
        return dao.salvar(sala);
    }

    @Override
    public Sala consultarPorId(Long id) {
        SalaDAO dao = new SalaDAO(em);
        return dao.consultarPorId(id);
    }

    @Override
    public void remover(Long id) {
        SalaDAO dao = new SalaDAO(em);
        dao.remover(id);
    }

    @Override
    public List<Sala> consultarSalas() {
        SalaDAO dao = new SalaDAO(em);
        return dao.consultarSalas();
    }   
}