package com.pedrovbo.bootcamp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TB_MENTORIA")
@SequenceGenerator(name = "MEN_SEQ", sequenceName = "MENTORIA_SEQ",
    initialValue = 1, allocationSize = 1)
public class Mentoria extends Conteudo {

    private static final long serialVersionUID
            = -4023522856316087762L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "MEN_SEQ")
    private Long id;

    @Column
    private LocalDate data;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
