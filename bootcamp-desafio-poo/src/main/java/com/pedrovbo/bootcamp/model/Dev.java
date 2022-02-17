package com.pedrovbo.bootcamp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name= "TB_DEV")
@SequenceGenerator(name = "DEV_SEQ", sequenceName = "DEV_SEQUENCE",
    initialValue = 1, allocationSize = 1)
public class Dev implements Serializable {

    private static final long serialVersionUID
            = -4023522856316087762L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "DEV_SEQ")
    private Long id;

    @Column(name = "nome", nullable = false, length = 40)
    private String nome;

    //TODO: Estudar como implementar Set
//    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
//    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    /*public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }*/
}
