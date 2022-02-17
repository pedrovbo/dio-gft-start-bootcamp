package com.pedrovbo.bootcamp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TB_MENTORIA")
@SequenceGenerator(name = "MEN_SEQ", sequenceName = "MENTORIA_SEQ",
    initialValue = 1, allocationSize = 1)
public class Mentoria implements Serializable {

    private static final long serialVersionUID
            = -4023522856316087762L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "MEN_SEQ")
    private Long id;

    @Column(name = "data")
    private LocalDate data;
    @Column
    protected static final double XP_PADRAO = 10d;
    @Column(name = "titulo", nullable = false, length = 20)
    private String titulo;
    @Column(name = "descricao", length = 100)
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
