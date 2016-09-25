package br.com.euemais3.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "FORNECEDOR_SEQ", sequenceName = "FORNECEDOR_SEQ", initialValue = 1, allocationSize = 1)
public class Fornecedor implements Serializable{
    private static final long serialVersionUID = 1144388379176007879L;

    public Fornecedor() {
    }

    public Fornecedor(Long id, String fornecedor, String telefone) {
        this.id = id;
        this.fornecedor = fornecedor;
        this.telefone = telefone;
    }
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FORNECEDOR_SEQ")
    private Long id;
    @Column(nullable = false)
    private String fornecedor;
    private String telefone;


    public Long getId() {return id;}
    public String getFornecedor() {return fornecedor;}
    public String getTelefone() {return telefone;}
    
    
    public void setId(Long id) {this.id = id;}
    public void setFornecedor(String fornecedor) {this.fornecedor = fornecedor;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
}
