package app;

import bancos.Banco;
import clientes.Cliente;
import contas.Conta;
import contas.ContaCorrente;

import java.util.Scanner;

import static bancos.Banco.getClientes;
import static telas.GerarTela.listarBancos;


public class Program {



    public static void main(String[] args) {
        Scanner lerTexto = new Scanner(System.in);
        Scanner lerNumero = new Scanner(System.in);
        String escolha;



        System.out.println("Bem-vindo!");

        System.out.println("Gostaria de abrir uma conta? S/N");
        escolha = lerTexto.next();

        if(escolha.toUpperCase().contentEquals("N")){
            System.out.println("Obrigado, volte sempre!");
        } else if(escolha.toUpperCase().contentEquals("S")){
            System.out.println("Diga seu nome e o nome do banco desejado: ");
            listarBancos();
            System.out.println();
        }




//        Banco bradesco = new Banco("Bradesco");
//        Cliente cliente = new Cliente("Pedro", bradesco);
//        Conta conta = new ContaCorrente(cliente);
//        Cliente cliente1 = new Cliente("Gessica", bradesco);
//
//        // System.out.println(cliente.getNome());
//
//        conta.imprimirExtrato();
//
//        // System.out.println(cliente.toString());
//
//
//        //setClientes(cliente1);
//        getClientes();


    }

}
