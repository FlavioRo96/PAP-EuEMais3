package br.com.euemais3.bo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "idioma_seq", sequenceName = "idioma_seq", initialValue = 1, allocationSize = 1)
public class Idioma implements Serializable {
    private static final long serialVersionUID = 1835646277105366809L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idioma_seq")
    private Long id;
    @Column(nullable = false)
    private String idioma;

    public Idioma() {
    }

    public Idioma(Long id, String idioma) {
        this.id = id;
        this.idioma = idioma;
    }

    public Long getId() {return id;}
    public String getIdioma() {return idioma;}

    public void setId(Long id) {this.id = id;}
    public void setIdioma(String idioma) {this.idioma = idioma;}    
    
    
    public static abstract class ListQueryName {
        public static final String consultarTodos = "consultarTodos";
    }
    
    protected static abstract class ListQuery {
        public static final String consultarTodos = "select i from idioma i";
    }
}
