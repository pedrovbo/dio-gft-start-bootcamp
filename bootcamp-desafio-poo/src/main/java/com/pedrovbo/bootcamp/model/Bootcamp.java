package com.pedrovbo.bootcamp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TB_BOOTCAMP")
@SequenceGenerator(name="BOOT_SEQ", sequenceName = "BOOTCAMP_SEQ",
    initialValue = 1, allocationSize = 1)
public class Bootcamp implements Serializable {

    private static final long serialVersionUID
            = -4023522856316087762L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "BOOT_SEQ")
    private Long id;
    @Column(name = "nome", nullable = false, length = 30)
    private String nome;
    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;
    @Column(name = "data_inicio", nullable = false)
    private final LocalDate dataInicial = LocalDate.now();
    @Column(name = "data_fim", nullable = true)
    private final LocalDate dataFinal = dataInicial.plusDays(45);

    //TODO: Estudar como implementar estes
//    private Set<Dev> devsInscritos = new HashSet<>();
//    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    /*public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public void setDevsInscritos(Set<Dev> devsInscritos) {
        this.devsInscritos = devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }*/
}
