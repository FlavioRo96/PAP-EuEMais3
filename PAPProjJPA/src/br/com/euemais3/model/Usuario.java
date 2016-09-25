package br.com.euemais3.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "USUARIO_SEQ", sequenceName = "USUARIO_SEQ", initialValue = 1, allocationSize = 1)
public class Usuario implements Serializable{
    private static final long serialVersionUID = -8247634916452822541L;

    public Usuario() {
    }

    public Usuario(Long id, String usuario, String nome, String sobrenome, Date dataNasc) {
        this.id = id;
        this.usuario = usuario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
    }
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQ")
    private Long id;
    @Column(nullable = false)
    private String usuario;
    @Column(nullable = false)
    private String nome;
    private String sobrenome;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
//    @Column(nullable = false)
//    private TipoConta tipoDeConta;

    public Long getId() {return id;}
    public String getUsuario() {return usuario;}
    public String getNome() {return nome;}
    public String getSobrenome() {return sobrenome;}
    public Date getDataNasc() {return dataNasc;}
//    public TipoConta getTipoDeConta() {return tipoDeConta;}

    
    public void setId(Long id) {this.id = id;}
    public void setUsuario(String usuario) {this.usuario = usuario;}
    public void setNome(String nome) {this.nome = nome;}
    public void setSobrenome(String sobrenome) {this.sobrenome = sobrenome;}
    public void setDataNasc(Date dataNasc) {this.dataNasc = dataNasc;}
//    public void setTipoDeConta(TipoConta tipoDeConta) {this.tipoDeConta = tipoDeConta;}
}