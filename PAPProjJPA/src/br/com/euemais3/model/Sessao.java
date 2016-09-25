package br.com.euemais3.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "SESSAO_SEQ", sequenceName = "SESSAO_SEQ", initialValue = 1, allocationSize = 1)
public class Sessao implements Serializable{
    private static final long serialVersionUID = -4055644853155171133L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SESSAO_SEQ")
    private Long id;
    @ManyToOne
    private Filme filme;
    @ManyToOne
    private Fornecedor fornecedor;
    private Date data;
    private Double valor;

    public Sessao() {
    }

    public Sessao(Long id, Filme filme, Fornecedor fornecedor, Date data, Double valor) {
        this.id = id;
        this.filme = filme;
        this.fornecedor = fornecedor;
        this.data = data;
        this.valor = valor;
    }

    
    public Long getId() {return id;}
    public Filme getFilme() {return filme;}
    public Fornecedor getFornecedor() {return fornecedor;}
    public Date getData() {return data;}
    public Double getValor() {return valor;}
    
    
    public void setId(Long id) {this.id = id;}
    public void setFilme(Filme filme) {this.filme = filme;}
    public void setFornecedor(Fornecedor fornecedor) {this.fornecedor = fornecedor;}
    public void setData(Date data) {this.data = data;}
    public void setValor(Double valor) {this.valor = valor;}
}
