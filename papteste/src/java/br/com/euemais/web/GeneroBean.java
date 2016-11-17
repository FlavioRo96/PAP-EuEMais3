package br.com.euemais.web;

import br.com.euemais3.ejbproj.bo.Genero;
import br.com.euemais3.ejbproj.ejb.interfaces.GeneroRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class GeneroBean {

    private Genero genero;
    @EJB
    private GeneroRemote ejb;

    public GeneroBean(Genero genero) {
        this.genero = genero;
    }

    public void salvar() {
        ejb.salvar(genero);
        genero = new Genero();
    }

    public void remover() {
        ejb.remover(genero.getId());
        genero = new Genero();
    }

    public Genero consultarPorId() {
        return ejb.consultarPorId(genero.getId());
    }

    public List<Genero> consultarGeneros() {
        return ejb.consultarGeneros();
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
