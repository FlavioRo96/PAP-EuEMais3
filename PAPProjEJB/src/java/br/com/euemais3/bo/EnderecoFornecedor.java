package br.com.euemais3.bo;

import java.util.List;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "ENDERECOFORNECEDOR_SEQ", sequenceName = "ENDERECOFORNECEDOR_SEQ", initialValue = 1, allocationSize = 1)
@NamedQueries({
    @NamedQuery(name = EnderecoFornecedor.ListQueryName.consultarTodos, query = EnderecoFornecedor.ListQuery.consultarTodos)
})
public class EnderecoFornecedor extends Endereco{
    private static final long serialVersionUID = 7937681050642595502L;
    
    
    private List<Fornecedor> fornecedor;
    
    public EnderecoFornecedor() {
    }

    public EnderecoFornecedor(Long id, List<Fornecedor> fornecedor, String rua, String numero, String bairro, String complemento, String cep, String uf, String cidade) {
        super(id, rua, numero, bairro, complemento, cep, uf, cidade);
        this.fornecedor = fornecedor;
    }
 
    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECOFORNECEDOR_SEQ")
    @Override
    public Long getId() {return super.getId();}
    
    @ManyToMany
    @JoinTable(name = "fornecedor_enderecofornecedor",
            joinColumns = @JoinColumn(name = "idEnderecofornecedor"),
            inverseJoinColumns = @JoinColumn(name = "idFornecedor"))
    public List<Fornecedor> getFornecedor() {return fornecedor;}    
      
    @Column(nullable = false)
    @Override
    public String getCidade() {return super.getCidade();}

    @Column(nullable = false)
    @Override
    public String getUf() {return super.getUf();}

    @Column(nullable = false)
    @Override
    public String getCep() {return super.getCep();}

    @Override
    public String getComplemento() {return super.getComplemento();}

    @Column(nullable = false)
    @Override
    public String getBairro() {return super.getBairro();}

    @Column(nullable = false)
    @Override
    public String getNumero() {return super.getNumero();}

    @Column(nullable = false)
    @Override
    public String getRua() {return super.getRua();}
    
    public void setFornecedor(List<Fornecedor> fornecedor) {this.fornecedor = fornecedor;}
    
    public static abstract class ListQueryName {
        public static final String consultarTodos = "consultarTodos";
    }
    
    protected static abstract class ListQuery {
        public static final String consultarTodos = "select e from EnderecoFornecedor e";
    }
}
