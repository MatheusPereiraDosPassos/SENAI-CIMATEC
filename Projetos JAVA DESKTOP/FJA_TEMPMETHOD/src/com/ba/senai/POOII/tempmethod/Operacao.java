/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ba.senai.POOII.tempmethod;

/**
 *
 * @author Matthew
 */
abstract public class Operacao {
    
    abstract public int handelOperacao(int valor1 , int valor2);
    
    public void EfetuaOperacao(int valor1 , int valor2){
        //Código bem complexo ou não
        int resultado = handelOperacao(valor1, valor2);
        System.out.println("O resultado é : "+ resultado);
    }
    
}
