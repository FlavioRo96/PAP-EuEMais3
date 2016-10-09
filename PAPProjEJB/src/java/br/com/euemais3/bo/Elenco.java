package br.com.euemais3.bo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "elenco_seq", sequenceName = "elenco_seq", initialValue = 1, allocationSize = 1)
public class Elenco implements Serializable {
    private static final long serialVersionUID = 1632814416777384374L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "elenco_seq")
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
    @Column(nullable = false)
    private String papel;
    @ManyToMany
    private Nacionalidade nacionalidade;

    public Elenco() {
    }

    public Elenco(Long id, String nome, Date dataNasc, String papel) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.papel = papel;
    }

    public Long getId() {return id;}
    public String getNome() {return nome;}
    public Date getDataNasc() {return dataNasc;}
    public String getPapel() {return papel;}
    public Nacionalidade getNacionalidade() {return nacionalidade;}
    
    public void setId(Long id) {this.id = id;   }
    public void setNome(String nome) {this.nome = nome;}
    public void setDataNasc(Date dataNasc) {this.dataNasc = dataNasc;}
    public void setPapel(String papel) {this.papel = papel;   }
    public void setNacionalidade(Nacionalidade nacionalidade) {this.nacionalidade = nacionalidade;}
    
    public static abstract class ListQueryName {
        public static final String consultarTodos = "consultarTodos";
    }
    
    protected static abstract class ListQuery {
        public static final String consultarTodos = "select e from elenco e";
    }
}
