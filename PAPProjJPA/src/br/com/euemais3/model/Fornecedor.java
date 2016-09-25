package br.com.euemais3.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "FORNECEDOR_SEQ", sequenceName = "FORNECEDOR_SEQ", initialValue = 1, allocationSize = 1)
public class Fornecedor implements Serializable{
    private static final long serialVersionUID = 1144388379176007879L;

    public Fornecedor() {
    }

    public Fornecedor(Long id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FORNECEDOR_SEQ")
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String telefone;
    @OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EnderecoFornecedor> enderecoFornecedor;


    public Long getId() {return id;}
    public String getNome() {return nome;}
    public String getTelefone() {return telefone;}
    public List<EnderecoFornecedor> getEnderecoFornecedor() {return enderecoFornecedor;}
    
    
    public void setId(Long id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public void setEnderecoFornecedor(List<EnderecoFornecedor> enderecoFornecedor) {this.enderecoFornecedor = enderecoFornecedor;}
}
