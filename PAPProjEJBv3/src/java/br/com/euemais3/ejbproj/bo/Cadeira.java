package br.com.euemais3.ejbproj.bo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "cadeira_seq", sequenceName = "cadeira_seq", initialValue = 1, allocationSize = 1)
public class Cadeira implements Serializable {
    private static final long serialVersionUID = 7896005861289747180L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cadeira_seq")
    private Long id;
    private Integer numero;
    private Sala sala;

    public Cadeira() {
    }

    public Cadeira(Long id, Integer numero, Sala sala) {
        this.id = id;
        this.numero = numero;
        this.sala = sala;
    }

    public Long getId() {return id;}
    public Integer getNumero() {return numero;}
    public Sala getSala() {return sala;}

    public void setId(Long id) {this.id = id;}
    public void setNumero(Integer numero) {this.numero = numero;}
    public void setSala(Sala sala) {this.sala = sala;}
    
    public static abstract class ListQueryName {
        public static final String consultarTodos = "consultarTodos";
    }
    
    protected static abstract class ListQuery {
        public static final String consultarTodos = "select c from cadeira c";
    }
}
