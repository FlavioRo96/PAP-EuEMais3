package br.com.euemais3.ejbproj.ejb;

import br.com.euemais3.ejbproj.bo.Endereco;
import br.com.euemais3.ejbproj.bo.TipoConta;
import br.com.euemais3.ejbproj.dao.EnderecoDAO;
import br.com.euemais3.ejbproj.ejb.interfaces.EnderecoRemote;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EnderecoEJB implements EnderecoRemote {

    @PersistenceContext(unitName = "PAPProjEJBv3PU")
    private EntityManager em;

    @Override
    public Endereco salvar(Endereco tipoConta) {
        EnderecoDAO dao = new EnderecoDAO(em);
        return dao.salvar(tipoConta);
    }

    @Override
    public Endereco consultarPorId(Long id) {
        EnderecoDAO dao = new EnderecoDAO(em);
        return dao.consultarPorId(id);
    }

    @Override
    public void remover(Long id) {
        EnderecoDAO dao = new EnderecoDAO(em);
        dao.remover(id);
    }

    @Override
    public List<Endereco> consultarEnderecos() {
        EnderecoDAO dao = new EnderecoDAO(em);
        return dao.consultarSalas();
    }
}