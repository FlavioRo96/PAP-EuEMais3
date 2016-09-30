package br.com.euemais3.ejb.interfaces;

import br.com.euemais3.bo.Usuario;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface UsuarioRemote {

    public Usuario salvar(Usuario usuario);

    public Usuario consultarPorId(Long id);

    public void remover(Long id);

    public List<Usuario> consultarUsuario();

}
