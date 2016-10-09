package br.com.euemais3.bo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "distribuidor_seq", sequenceName = "distribuidor_seq", initialValue = 1, allocationSize = 1)
public class Distribuidor implements Serializable {
    private static final long serialVersionUID = -151800816932987933L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "distribuidor_seq")
    private Long id;
    @Column(nullable = false)
    private String nome;

    public Distribuidor() {
    }

    public Distribuidor(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {return id;}
    public String getNome() {return nome;}

    public void setId(Long id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    
    public static abstract class ListQueryName {
        public static final String consultarTodos = "consultarTodos";
    }
    
    protected static abstract class ListQuery {
        public static final String consultarTodos = "select d from distribuidor d";
    }
}
