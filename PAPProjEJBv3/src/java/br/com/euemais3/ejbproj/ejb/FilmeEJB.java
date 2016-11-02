package br.com.euemais3.ejbproj.ejb;

import br.com.euemais3.ejbproj.bo.Filme;
import br.com.euemais3.ejbproj.bo.Fornecedor;
import br.com.euemais3.ejbproj.bo.Genero;
import br.com.euemais3.ejbproj.bo.TipoConta;
import br.com.euemais3.ejbproj.dao.FilmeDAO;
import br.com.euemais3.ejbproj.dao.FornecedorDAO;
import br.com.euemais3.ejbproj.dao.GeneroDAO;
import br.com.euemais3.ejbproj.dao.TipoContaDAO;
import br.com.euemais3.ejbproj.ejb.interfaces.FilmeRemote;
import br.com.euemais3.ejbproj.ejb.interfaces.FornecedorRemote;
import br.com.euemais3.ejbproj.ejb.interfaces.GeneroRemote;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FilmeEJB implements FilmeRemote {

    @PersistenceContext(unitName = "PAPProjEJBv3PU")
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
        return dao.consultarFilmes();
    }
}