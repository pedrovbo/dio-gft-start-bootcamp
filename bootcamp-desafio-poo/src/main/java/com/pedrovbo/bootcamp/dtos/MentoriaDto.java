package com.pedrovbo.bootcamp.dtos;

import javax.persistence.Column;
import java.time.LocalDate;

public class MentoriaDto {

    private LocalDate data;
    protected static final double XP_PADRAO = 10d;
    private String titulo;
    private String descricao;

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
