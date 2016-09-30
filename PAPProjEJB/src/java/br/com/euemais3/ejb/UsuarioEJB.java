package br.com.euemais3.ejb;

import br.com.euemais3.bo.Usuario;
import br.com.euemais3.dao.UsuarioDAO;
import br.com.euemais3.ejb.interfaces.UsuarioRemote;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UsuarioEJB implements UsuarioRemote {

    @PersistenceContext(unitName = "PAPProjPU")
    private EntityManager em;

    @Override
    public Usuario salvar(Usuario usuario) {
        UsuarioDAO dao = new UsuarioDAO(em);
        return dao.salvar(usuario);
    }

    @Override
    public Usuario consultarPorId(Long id) {
        UsuarioDAO dao = new UsuarioDAO(em);
        return dao.consultarPorId(id);
    }

    @Override
    public void remover(Long id) {
        UsuarioDAO dao = new UsuarioDAO(em);
        em.remove(id);
    }

    @Override
    public List<Usuario> consultarUsuario() {
        UsuarioDAO dao = new UsuarioDAO(em);
        return dao.consultarMedalhas();
    }
}