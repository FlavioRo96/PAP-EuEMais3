package br.com.euemais3.bo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "FILME_SEQ", sequenceName = "FILME_SEQ", initialValue = 1, allocationSize = 1)
@NamedQueries({
    @NamedQuery(name = Filme.ListQueryName.consultarTodos, query = Filme.ListQueryName.consultarTodos)
})
public class Filme implements Serializable{
    private static final long serialVersionUID = 1125928869259985471L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILME_SEQ")
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sinopse;
    @Temporal(TemporalType.DATE)
    private Date anoProducao;
    private String direcao;
    @Column(nullable = false)
    private String distribuidor;
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date duracao;
    @Column(nullable = false)
    private Genero genero;
    
    public Filme() {
    }

    public Filme(Long id, String nome, String sinopse, Date anoProducao, String direcao, String distribuidor, Date duracao, Genero genero) {
        this.id = id;
        this.nome = nome;
        this.sinopse = sinopse;
        this.anoProducao = anoProducao;
        this.direcao = direcao;
        this.distribuidor = distribuidor;
        this.duracao = duracao;
        this.genero = genero;
    }

    public Long getId() {return id;}
    public String getNome() {return nome;}
    public String getSinopse() {return sinopse;}
    public Date getAnoProducao() {return anoProducao;}
    public String getDirecao() {return direcao;}
    public String getDistribuidor() {return distribuidor;}
    public Date getDuracao() {return duracao;}
    public Genero getGenero() {return genero;}
    
    
    public void setId(Long id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setSinopse(String sinopse) {this.sinopse = sinopse;}
    public void setAnoProducao(Date anoProducao) {this.anoProducao = anoProducao;}
    public void setDirecao(String direcao) {this.direcao = direcao;}
    public void setDistribuidor(String distribuidor) {this.distribuidor = distribuidor;}
    public void setDuracao(Date duracao) {this.duracao = duracao;}
    public void setGenero(Genero genero) {this.genero = genero;}
    
    public static abstract class ListQueryName {
        public static final String consultarTodos = "consultarTodos";
    }
    
    protected static abstract class ListQuery {
        public static final String consultarTodos = "select f from Filme f";
    }
}
