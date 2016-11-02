package br.com.euemais3.ejbproj.bo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "SESSAO_SEQ", sequenceName = "SESSAO_SEQ", initialValue = 1, allocationSize = 1)
public class Sessao implements Serializable{
    private static final long serialVersionUID = -4055644853155171133L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SESSAO_SEQ")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFilme")
    private Filme filme;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCadeira")
    private Cadeira cadeira;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(nullable = false, precision = 3, scale = 2)
    private Double valor;

    public Sessao() {
    }

    public Sessao(Long id, Filme filme, Cadeira cadeira, Date data, Double valor) {
        this.id = id;
        this.filme = filme;
        this.cadeira = cadeira;
        this.data = data;
        this.valor = valor;
    }

    
    public Long getId() {return id;}
    public Filme getFilme() {return filme;}
    public Cadeira getCadeira() {return cadeira;}
    public Date getData() {return data;}
    public Double getValor() {return valor;}
    
    
    public void setId(Long id) {this.id = id;}
    public void setFilme(Filme filme) {this.filme = filme;}
    public void setCadeira(Cadeira cadeira) {this.cadeira = cadeira;}
    public void setData(Date data) {this.data = data;}
    public void setValor(Double valor) {this.valor = valor;}
}
