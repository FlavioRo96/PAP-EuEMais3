package br.com.euemais3.model;

import javax.persistence.*;

@Entity
public class EnderecoFornecedor extends Endereco{
    private static final long serialVersionUID = 7937681050642595502L;
    
    
    private Fornecedor fornecedor;
    
    public EnderecoFornecedor() {
    }

    public EnderecoFornecedor(Long id, Fornecedor fornecedor, String rua, String numero, String bairro, String complemento, String cep, String uf, String cidade) {
        super(id, rua, numero, bairro, complemento, cep, uf, cidade);
        this.fornecedor = fornecedor;
    }
 
    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECOFORNECEDOR_SEQ")
    @Override
    public Long getId() {return super.getId();}
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFornecedor")
    public Fornecedor getFornecedor() {return fornecedor;}    
      
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
    
    public void setUsuario(Fornecedor fornecedor) {this.fornecedor = fornecedor;}
}
