package br.com.euemais.web;

import br.com.euemais3.ejbproj.bo.Usuario;
import br.com.euemais3.ejbproj.ejb.interfaces.UsuarioRemote;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
public class UsuarioBean {

    private Usuario user = new Usuario();
    @EJB
    private UsuarioRemote ejb;

//    public UsuarioBean(Usuario user) {
//        this.user = user;
//    }

    public void logar() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession sessao = (HttpSession) ctx.getExternalContext();

        if (ejb.consultarPorUsuario(user) != null) {
            try {
                sessao.setAttribute("usuarioLogado", new Object());
                ctx.getExternalContext().redirect("index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(redirecionamentoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            ctx.getExternalContext().redirect("login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(redirecionamentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deslogar() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession sessao = (HttpSession) ctx.getExternalContext();

        if (sessao.getAttribute("usuarioLogado") != null) {
            sessao.removeAttribute("usuarioLogado");
        }

    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

}
