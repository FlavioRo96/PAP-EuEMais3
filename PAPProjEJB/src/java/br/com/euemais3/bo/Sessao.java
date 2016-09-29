package br.com.euemais3.bo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "SESSAO_SEQ", sequenceName = "SESSAO_SEQ", initialValue = 1, allocationSize = 1)
@NamedQueries({
    @NamedQuery(name = Sessao.ListQueryName.consultarTodos, query = Sessao.ListQuery.consultarTodos)
})
public class Sessao implements Serializable{
    private static final long serialVersionUID = -4055644853155171133L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SESSAO_SEQ")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFilme")
    private Filme filme;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idSala")
    private Sala sala;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(nullable = false, precision = 3, scale = 2)
    private Double valor;

    public Sessao() {
    }

    public Sessao(Long id, Filme filme, Sala sala, Date data, Double valor) {
        this.id = id;
        this.filme = filme;
        this.sala = sala;
        this.data = data;
        this.valor = valor;
    }

    
    public Long getId() {return id;}
    public Filme getFilme() {return filme;}
    public Sala getSala() {return sala;}
    public Date getData() {return data;}
    public Double getValor() {return valor;}
    
    
    public void setId(Long id) {this.id = id;}
    public void setFilme(Filme filme) {this.filme = filme;}
    public void setSala(Sala sala) {this.sala = sala;}
    public void setData(Date data) {this.data = data;}
    public void setValor(Double valor) {this.valor = valor;}
    
    public static abstract class ListQueryName {
        public static final String consultarTodos = "consultarTodos";
    }
    
    protected static abstract class ListQuery {
        public static final String consultarTodos = "select s from Sessao s";
    }
}
