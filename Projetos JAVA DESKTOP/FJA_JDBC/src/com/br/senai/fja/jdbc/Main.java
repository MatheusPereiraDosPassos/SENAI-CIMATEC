/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.senai.fja.jdbc;

/**
 *
 * @author Matthew
 */
public class Main {

    public static void main(String[] args) {
        
        AcessoBanco acessobanco = new AcessoBanco();
        System.out.println("\nIniciando Teste com o banco \n\n\n");
        System.out.println("Tentando abrir a conexão\n");
        acessobanco.criaAbreConexao();
        System.out.println("Conexão realizada com sucesso\n\n\n");
        System.out.println("Tentando fechar a conexão\n");
        acessobanco.fechaConexao();
        System.out.println("Conexão finalizada... OK");
    }

}
