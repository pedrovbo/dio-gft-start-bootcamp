package com.pedrovbo.bootcamp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_CURSO")
@SequenceGenerator(name="CUR_SEQ", sequenceName = "CURSO_SEQ",
    initialValue = 1, allocationSize = 1)
public class Curso implements Serializable {

    private static final long serialVersionUID
            = -4023522856316087762L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "CUR_SEQ")
    private Long id;
    @Column(name = "carga_horaria", nullable = false)
    private int cargaHoraria;

    @Column
    protected static final double XP_PADRAO = 10d;
    @Column(nullable = false, length = 20)
    private String titulo;
    @Column(length = 100)
    private String descricao;

    //TODO: Pesquisar como implementar os atributos da interface Conteudo no Banco de Dados

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
