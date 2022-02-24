package com.pedrovbo.emprestimolivros.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    // TODO: talvez implementar atributo endereço e fazer integração com o VIACEP API
}
