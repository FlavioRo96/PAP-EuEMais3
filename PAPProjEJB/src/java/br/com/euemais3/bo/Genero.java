package br.com.euemais3.bo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "genero_seq", sequenceName = "genero_seq", initialValue = 1, allocationSize = 1)
public class Genero implements Serializable {
    private static final long serialVersionUID = -3602010137620286429L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genero_seq")
    private Long id;
    @Column(nullable = false)
    private String genero;

    public Long getId() {return id;}
    public String getGenero() {return genero;}

    public void setId(Long id) {this.id = id;}
    public void setGenero(String genero) {this.genero = genero;}
    
    public static abstract class ListQueryName {
        public static final String consultarTodos = "consultarTodos";
    }
    
    protected static abstract class ListQuery {
        public static final String consultarTodos = "select g from genero g";
    }
}
