package com.pedrovbo.bootcamp.dtos;

import javax.persistence.Column;

public class CursoDto {

    private int cargaHoraria;
    protected static final double XP_PADRAO = 10d;
    private String titulo;
    private String descricao;

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
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
