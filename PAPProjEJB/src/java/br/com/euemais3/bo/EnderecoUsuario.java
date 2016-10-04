package br.com.euemais3.bo;

import java.util.List;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "ENDERECOUSUARIO_SEQ", sequenceName = "ENDERECOUSUARIO_SEQ", initialValue = 1, allocationSize = 1)
@NamedQueries({
    @NamedQuery(name=EnderecoUsuario.ListQueryName.consultarTodos, query = EnderecoUsuario.ListQuery.consultarTodos)
})
public class EnderecoUsuario extends Endereco{
    private static final long serialVersionUID = -8403841393670819313L;

    private List<Usuario> usuario;
    
    public EnderecoUsuario() {
    }

    public EnderecoUsuario(Long id, List<Usuario> usuario, String rua, String numero, String bairro, String complemento, String cep, String uf, String cidade) {
        super(id, rua, numero, bairro, complemento, cep, uf, cidade);
        this.usuario = usuario;
    }
 
    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECOUSUARIO_SEQ")
    @Override
    public Long getId() {return super.getId();}
    
    @ManyToMany
    @JoinTable(name = "usuario_enderecousuario",
            joinColumns = @JoinColumn(name = "idEnderecousuario"),
            inverseJoinColumns = @JoinColumn(name = "idUsuario"))
    public List<Usuario> getUsuario() {return usuario;}    
      
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
    
    public void setUsuario(List<Usuario> usuario) {this.usuario = usuario;}
    
    public static abstract class ListQueryName {
        public static final String consultarTodos = "consultarTodos";
    }
    
    protected static abstract class ListQuery {
        public static final String consultarTodos = "select e from EnderecoUsuario e";
    }
}
