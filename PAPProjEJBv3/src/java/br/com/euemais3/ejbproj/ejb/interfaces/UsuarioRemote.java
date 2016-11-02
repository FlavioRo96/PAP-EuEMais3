package br.com.euemais3.ejbproj.ejb.interfaces;

import br.com.euemais3.ejbproj.bo.Usuario;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface UsuarioRemote {

    public Usuario salvar(Usuario usuario);

    public Usuario consultarPorUsuario(Usuario usuario);

    public void remover(Long id);

    public List<Usuario> consultarUsuarios();

}
