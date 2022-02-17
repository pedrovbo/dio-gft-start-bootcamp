package com.pedrovbo.bootcamp.model;

import java.time.LocalDate;

public class Mentoria extends Conteudo {
    private LocalDate data;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
