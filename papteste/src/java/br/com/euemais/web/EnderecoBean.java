package br.com.euemais.web;

import br.com.euemais3.ejbproj.bo.Endereco;
import br.com.euemais3.ejbproj.ejb.interfaces.EnderecoRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class EnderecoBean {

    private Endereco endereco;
    @EJB
    private EnderecoRemote ejb;

    public EnderecoBean(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco salvar() {
        Endereco f = ejb.salvar(endereco);
        endereco = new Endereco();
        return f;
    }

    public void remover() {
        ejb.remover(endereco.getId());
        endereco = new Endereco();
    }

    public Endereco consultarPorId() {
        return ejb.consultarPorId(endereco.getId());
    }

    public List<Endereco> consultarEnderecos() {
        return ejb.consultarEnderecos();
    }
}
