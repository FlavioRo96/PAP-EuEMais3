package br.com.euemais3.ejb;

import br.com.euemais3.bo.EnderecoUsuario;
import br.com.euemais3.dao.EnderecoUsuarioDAO;
import br.com.euemais3.ejb.interfaces.EnderecoUsuarioRemote;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EnderecoUsuarioEJB implements EnderecoUsuarioRemote{
    @PersistenceContext(unitName = "PAPProjPU")
    private EntityManager em;

    @Override
    public EnderecoUsuario salvar(EnderecoUsuario enderecoUsuario) {
        EnderecoUsuarioDAO dao = new EnderecoUsuarioDAO(em);
        return dao.salvar(enderecoUsuario);
    }

    @Override
    public EnderecoUsuario consultarPorId(Long id) {
        EnderecoUsuarioDAO dao = new EnderecoUsuarioDAO(em);
        return dao.consultarPorId(id);
    }

    @Override
    public void remover(Long id) {
        EnderecoUsuarioDAO dao = new EnderecoUsuarioDAO(em);
        dao.remover(id);
    }

    @Override
    public List<EnderecoUsuario> consultarEnderecosUsuarios() {
        EnderecoUsuarioDAO dao = new EnderecoUsuarioDAO(em);
        return dao.consultarEnderecosUsuarios();
    }
}