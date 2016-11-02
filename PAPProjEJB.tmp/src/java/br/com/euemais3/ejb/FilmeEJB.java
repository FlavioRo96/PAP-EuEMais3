package br.com.euemais3.ejb;

import br.com.euemais3.bo.Filme;
import br.com.euemais3.dao.FilmeDAO;
import br.com.euemais3.ejb.interfaces.FilmeRemote;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class FilmeEJB implements FilmeRemote{
    @PersistenceContext(unitName = "PAPProjPU")
    private EntityManager em;
    
    @Override
    public Filme salvar(Filme filme) {
        FilmeDAO dao = new FilmeDAO(em);
        return dao.salvar(filme);
    }

    @Override
    public Filme consultarPorId(Long id) {
        FilmeDAO dao = new FilmeDAO(em);
        return dao.consultarPorId(id);
    }

    @Override
    public void remover(Long id) {
        FilmeDAO dao = new FilmeDAO(em);
        dao.remover(id);
    }

    @Override
    public List<Filme> consultarFilmes() {
        FilmeDAO dao = new FilmeDAO(em);
        return dao.consultarUsuarios();
    }   
}
