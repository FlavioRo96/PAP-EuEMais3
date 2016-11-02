package br.com.euemais3.ejbproj.ejb;

import br.com.euemais3.ejbproj.bo.Usuario;
import br.com.euemais3.ejbproj.dao.UsuarioDAO;
import br.com.euemais3.ejbproj.ejb.interfaces.UsuarioRemote;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UsuarioEJB implements UsuarioRemote {

    @PersistenceContext(unitName = "PAPProjEJBv3PU")
    private EntityManager em;

    @Override
    public Usuario salvar(Usuario usuario) {
        UsuarioDAO dao = new UsuarioDAO(em);
        return dao.salvar(usuario);
    }

    @Override
    public Usuario consultarPorUsuario(Usuario usuario) {
        UsuarioDAO dao = new UsuarioDAO(em);
        return dao.consultarPorId(usuario.getId());
    }

    @Override
    public void remover(Long id) {
        UsuarioDAO dao = new UsuarioDAO(em);
        em.remove(id);
    }

    @Override
    public List<Usuario> consultarUsuarios() {
        UsuarioDAO dao = new UsuarioDAO(em);
        return dao.consultarUsuarios();
    }
}