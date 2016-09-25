package br.com.euemais3.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "ENDERECOUSUARIO_SEQ", sequenceName = "ENDERECOUSUARIO_SEQ", initialValue = 1, allocationSize = 1)
public class EnderecoUsuario extends Endereco{

    public EnderecoUsuario() {
    }

    public EnderecoUsuario(Long id, String rua, String numero, String bairro, String complemento, String cep, String uf, String cidade) {
        super(id, rua, numero, bairro, complemento, cep, uf, cidade);
    }
    
    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECOUSUARIO_SEQ")
    @Override
    public Long getId() {return super.getId();}
    
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

}
