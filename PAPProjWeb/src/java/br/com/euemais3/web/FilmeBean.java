package br.com.euemais3.web;

import br.com.euemais3.ejbproj.bo.Filme;
import br.com.euemais3.ejbproj.ejb.interfaces.FilmeRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class FilmeBean {

    private Filme filme;
    @EJB
    private FilmeRemote ejb;

    public FilmeBean(Filme filme) {
        this.filme = filme;
    }

    public void salvar() {
        ejb.salvar(filme);
        filme = new Filme();
    }

    public void consultarPorId() {
        ejb.consultarPorId(filme.getId());
        filme = new Filme();
    }

    public void remover() {
        ejb.remover(filme.getId());
        filme = new Filme();
    }

    public List<Filme> consultarFilmes() {
        return ejb.consultarFilmes();
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

}
