package br.com.euemais3.ejbproj.bo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "SALA_SEQ", sequenceName = "SALA_SEQ", initialValue = 1, allocationSize = 1)
public class Sala implements Serializable{
    private static final long serialVersionUID = -1252677403274396707L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SALA_SEQ")
    private Long id;
    @Column(nullable = false)
    private String nome;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idFornecedor")
    private Fornecedor fornecedor;

    public Sala() {
    }

    public Sala(Long id, String nome, Fornecedor fornecedor) {
        this.id = id;
        this.nome = nome;
        this.fornecedor = fornecedor;
    }

    
    public Long getId() {return id;}
    public String getNome() {return nome;}
    public Fornecedor getFornecedor() {return fornecedor;}
    
    
    public void setId(Long id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setFornecedor(Fornecedor fornecedor) {this.fornecedor = fornecedor;}
}
