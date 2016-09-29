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

    public Filme() {
    }

    public Filme(Long id, String nome, String sinopse, Date anoProducao, String direcao, String distribuidor, Date duracao, String genero, String elenco, String nacionalidade, String idioma, String cor, String formatoAudio) {
        this.id = id;
        this.nome = nome;
        this.sinopse = sinopse;
        this.anoProducao = anoProducao;
        this.direcao = direcao;
        this.distribuidor = distribuidor;
        this.duracao = duracao;
        this.genero = genero;
        this.elenco = elenco;
        this.nacionalidade = nacionalidade;
        this.idioma = idioma;
        this.cor = cor;
        this.formatoAudio = formatoAudio;
    }
    
    
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
    private String genero;
    private String elenco;
    private String nacionalidade;
    private String idioma;
    private String cor;
    private String formatoAudio;
    
    
    public Long getId() {return id;}
    public String getNome() {return nome;}
    public String getSinopse() {return sinopse;}
    public Date getAnoProducao() {return anoProducao;}
    public String getDirecao() {return direcao;}
    public String getDistribuidor() {return distribuidor;}
    public Date getDuracao() {return duracao;}
    public String getGenero() {return genero;}
    public String getElenco() {return elenco;}
    public String getNacionalidade() {return nacionalidade;}
    public String getIdioma() {return idioma;}
    public String getCor() {return cor;}
    public String getFormatoAudio() {return formatoAudio;}  
    
    
    public void setId(Long id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setSinopse(String sinopse) {this.sinopse = sinopse;}
    public void setAnoProducao(Date anoProducao) {this.anoProducao = anoProducao;}
    public void setDirecao(String direcao) {this.direcao = direcao;}
    public void setDistribuidor(String distribuidor) {this.distribuidor = distribuidor;}
    public void setDuracao(Date duracao) {this.duracao = duracao;}
    public void setGenero(String genero) {this.genero = genero;}
    public void setElenco(String elenco) {this.elenco = elenco;}
    public void setNacionalidade(String nacionalidade) {this.nacionalidade = nacionalidade;}
    public void setIdioma(String idioma) {this.idioma = idioma;}
    public void setCor(String cor) {this.cor = cor;}
    public void setFormatoAudio(String formatoAudio) {this.formatoAudio = formatoAudio;}
    
    public static abstract class ListQueryName {
        public static final String consultarTodos = "consultarTodos";
    }
    
    protected static abstract class ListQuery {
        public static final String consultarTodos = "select f from Filme f";
    }
}
