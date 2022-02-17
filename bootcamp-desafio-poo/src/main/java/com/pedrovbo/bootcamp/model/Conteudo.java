package com.pedrovbo.bootcamp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SequenceGenerator(name="CURS_SEQ", sequenceName = "CURSO_SEQ",
        initialValue = 1, allocationSize = 1)
public abstract class Conteudo implements Serializable {

    private static final long serialVersionUID
            = -4023522856316087762L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "BOOT_SEQ")
    private Long id;

    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;

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
