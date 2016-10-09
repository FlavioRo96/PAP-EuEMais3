package br.com.euemais3.bo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "nacionalidade_seq", sequenceName = "nacionalidade_seq", initialValue = 1, allocationSize = 1)
public class Nacionalidade implements Serializable {
    private static final long serialVersionUID = 358194949983686997L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nacionalidaed_seq")
    private Long id;
    @Column(nullable = false)
    private String nacionalidade;

    public Nacionalidade() {
    }

    public Nacionalidade(Long id, String nacionalidade) {
        this.id = id;
        this.nacionalidade = nacionalidade;
    }

    public Long getId() {return id;}
    public String getNacionalidade() {return nacionalidade;}

    public void setId(Long id) {this.id = id;}
    public void setNacionalidade(String nacionalidade) {this.nacionalidade = nacionalidade;}
    
    public static abstract class ListQueryName {
        public static final String consultarTodos = "consultarTodos";
    }
    
    protected static abstract class ListQuery {
        public static final String consultarTodos = "select n from nacionalidade n";
    }
}
