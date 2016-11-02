package br.com.euemais3.bo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "FORNECEDOR_SEQ", sequenceName = "FORNECEDOR_SEQ", initialValue = 1, allocationSize = 1)
@NamedQueries({
    @NamedQuery(name = Fornecedor.ListQueryName.consultarTodos, query = Fornecedor.ListQuery.consultarTodos)
})
public class Fornecedor implements Serializable{
    private static final long serialVersionUID = 1144388379176007879L;    
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FORNECEDOR_SEQ")
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String telefone;
    @ManyToMany(mappedBy = "fornecedor")
    private List<Endereco> enderecoFornecedor;

    public Fornecedor() {
    }

    public Fornecedor(Long id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public Long getId() {return id;}
    public String getNome() {return nome;}
    public String getTelefone() {return telefone;}
    public List<Endereco> getEnderecoFornecedor() {return enderecoFornecedor;}
    
    
    public void setId(Long id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public void setEnderecoFornecedor(List<Endereco> enderecoFornecedor) {this.enderecoFornecedor = enderecoFornecedor;}
    
    public static abstract class ListQueryName {
        public static final String consultarTodos = "consultarTodos";
    }
    
    protected static abstract class ListQuery {
        public static final String consultarTodos = "select f from Fornecedor f";
    }
}
