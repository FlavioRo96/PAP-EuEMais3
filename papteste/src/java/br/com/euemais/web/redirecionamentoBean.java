/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.euemais.web;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author icaro
 */
@ManagedBean
@RequestScoped
public class redirecionamentoBean implements Serializable {

    private String atributo;

    public void redirecionar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml#filme");
        } catch (IOException ex) {
            Logger.getLogger(redirecionamentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void outroRedirecionar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml#");
        } catch (IOException ex) {
            Logger.getLogger(redirecionamentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void metodo() {

    }

    public void index() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(redirecionamentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void categoria() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("categorias.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(redirecionamentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sobre() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("quemsomos.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(redirecionamentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void login() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(redirecionamentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the atributo
     */
    public String getAtributo() {
        return atributo;
    }

    /**
     * @param atributo the atributo to set
     */
    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }
}
