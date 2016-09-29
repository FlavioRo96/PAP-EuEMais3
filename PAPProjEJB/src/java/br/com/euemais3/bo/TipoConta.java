package br.com.euemais3.bo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "TIPOCONTA_SEQ", sequenceName = "TIPOCONTA_SEQ", initialValue = 1, allocationSize = 1)
@NamedQueries({
    @NamedQuery(name = TipoConta.ListQueryName.consultarTodos, query = TipoConta.ListQuery.consultarTodos)
})
public class TipoConta implements Serializable{
    private static final long serialVersionUID = -5659293654635911421L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPOCONTA_SEQ")
    private Long id;
    @Column(nullable = false)
    private String tipoconta;
    private String descricao;

    public TipoConta() {
    }

    public TipoConta(Long id, String tipoconta, String descricao) {
        this.id = id;
        this.tipoconta = tipoconta;
        this.descricao = descricao;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {return id;}
    public String getTipoconta() {return tipoconta;}
    public String getDescricao() {return descricao;}
    public void setId(Long id) {this.id = id;}
    public void setTipoconta(String tipoconta) {this.tipoconta = tipoconta;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    
    public static abstract class ListQueryName {
        public static final String consultarTodos = "consultarTodos";
    }
    
    protected static abstract class ListQuery {
        public static final String consultarTodos = "select t from TipoConta t";
    }
}
