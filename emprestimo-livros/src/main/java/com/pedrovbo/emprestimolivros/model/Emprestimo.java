package com.pedrovbo.emprestimolivros.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "LOANS")
public class Emprestimo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private int prazo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private static List<Livro> livroEmEmprestimo;
}
