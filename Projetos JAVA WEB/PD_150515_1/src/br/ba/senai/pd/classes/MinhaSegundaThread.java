/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.senai.pd.classes;

/**
 *
 * @author Matthew
 */
public class MinhaSegundaThread implements Runnable {

    @Override
    public void run() {
        while(true){
            System.out.println("Minha Thread com Runnable"); //sout
        }
    }
    
}
