package br.com.euemais3.bo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "formatoaudio_seq", sequenceName = "formatoaudio_seq", initialValue = 1, allocationSize = 1)
public class FormatoAudio implements Serializable {
    private static final long serialVersionUID = -7067813145152994653L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "formatoaudio_seq")
    private Long id;
    @Column(nullable = false)
    private String formato;

    public FormatoAudio() {
    }

    public FormatoAudio(Long id, String formato) {
        this.id = id;
        this.formato = formato;
    }
    
    public Long getId() {return id;}
    public String getFormato() {return formato;}

    public void setId(Long id) {this.id = id;}
    public void setFormato(String formato) {this.formato = formato;}
    
    public static abstract class ListQueryName {
        public static final String consultarTodos = "consultarTodos";
    }
    
    protected static abstract class ListQuery {
        public static final String consultarTodos = "select f from formatoaudio f";
    }
}
