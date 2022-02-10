package clientes;

import bancos.Banco;
import lombok.*;


@ToString
public class Cliente {

    @Getter(AccessLevel.PUBLIC)
    protected String nome;

    protected Banco banco;

    public Cliente(String nome, Banco banco){
        this.nome = nome;
        this.banco = banco;
        Banco.setClientes(this);
    }

    public String getBanco(){
        return this.banco.getNome();
    }
}
