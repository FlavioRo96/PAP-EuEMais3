package br.com.euemais3.ejbproj.ejb;

import br.com.euemais3.ejbproj.bo.Genero;
import br.com.euemais3.ejbproj.bo.TipoConta;
import br.com.euemais3.ejbproj.dao.GeneroDAO;
import br.com.euemais3.ejbproj.dao.TipoContaDAO;
import br.com.euemais3.ejbproj.ejb.interfaces.GeneroRemote;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GeneroEJB implements GeneroRemote {

    @PersistenceContext(unitName = "PAPProjEJBv3PU")
    private EntityManager em;

    @Override
    public Genero salvar(Genero tipoConta) {
        GeneroDAO dao = new GeneroDAO(em);
        return dao.salvar(tipoConta);
    }

    @Override
    public Genero consultarPorId(Long id) {
        GeneroDAO dao = new GeneroDAO(em);
        return dao.consultarPorId(id);
    }

    @Override
    public void remover(Long id) {
        GeneroDAO dao = new GeneroDAO(em);
        dao.remover(id);
    }

    @Override
    public List<Genero> consultarGeneros() {
        GeneroDAO dao = new GeneroDAO(em);
        return dao.consultarGeneros();
    }
}