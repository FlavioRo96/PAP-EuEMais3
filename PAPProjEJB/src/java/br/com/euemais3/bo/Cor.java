package br.com.euemais3.bo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "cor_seq", sequenceName = "cor_seq", initialValue = 1, allocationSize = 1)
public class Cor implements Serializable {
    private static final long serialVersionUID = -8804870641349126924L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cor_seq")
    private Long id;
    @Column(nullable = false)
    private String cor;

    public Cor() {
    }

    public Cor(Long id, String cor) {
        this.id = id;
        this.cor = cor;
    }

    public Long getId() {return id;}
    public String getCor() {return cor;}
    
    public void setId(Long id) {this.id = id;}
    public void setCor(String cor) {this.cor = cor;}
    
    public static abstract class ListQueryName {
        public static final String consultarTodos = "consultarTodos";
    }
    
    protected static abstract class ListQuery {
        public static final String consultarTodos = "select c from cor c";
    }
}
