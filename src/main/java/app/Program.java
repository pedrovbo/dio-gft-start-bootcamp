package app;

import bancos.Banco;
import clientes.Cliente;
import contas.Conta;
import contas.ContaCorrente;

import static bancos.Banco.getClientes;


public class Program {

    public static void main(String[] args) {


        Banco bradesco = new Banco("Bradesco");
        Cliente cliente = new Cliente("Pedro", bradesco);
        Conta conta = new ContaCorrente(cliente);
        Cliente cliente1 = new Cliente("Gessica", bradesco);

        // System.out.println(cliente.getNome());

        conta.imprimirExtrato();

        // System.out.println(cliente.toString());


        //setClientes(cliente1);
        getClientes();


    }

}
