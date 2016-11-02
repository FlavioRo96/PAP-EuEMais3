package br.com.euemais3.ejbproj.bo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "ENDERECO_SEQ", initialValue = 1, allocationSize = 1)
@NamedQueries({
    @NamedQuery(name = "consultarTodos.Endereco", query = "select e from Endereco e")
})
public class Endereco implements Serializable {

    private static final long serialVersionUID = 5961942539095552798L;

    @Id
    @GeneratedValue(generator = "ENDERECO_SEQ", strategy = GenerationType.AUTO)
    private Long id;
    private String rua;
    private String numero;
    private String bairro;
    private String complemento;
    private String cep;
    private String uf;
    private String cidade;
    @ManyToMany
    @JoinTable(name = "ENDERECO_USUARIO",
            joinColumns = {
                @JoinColumn(name = "ENDERECO_ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "USUARIO_ID")})
    private List<Usuario> usuarios;
    @ManyToMany
    @JoinTable(name = "ENDERECO_FORNECEDOR",
            joinColumns = {
                @JoinColumn(name = "ENDERECO_ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "FORNECEDOR_ID")})
    private List<Fornecedor> fornecedores;


    public Endereco() {
    }

    public Endereco(Long id, String rua, String numero, String bairro, String complemento, String cep, String uf, String cidade) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cep = cep;
        this.uf = uf;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCep() {
        return cep;
    }

    public String getUf() {
        return uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
