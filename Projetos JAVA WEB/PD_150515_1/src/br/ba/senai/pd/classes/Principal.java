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
public class Principal {
    public static void main(String[] args) {
        MinhaThread t1 = new MinhaThread();
        MinhaSegundaThread t2 = new MinhaSegundaThread();
        Thread t3 = new Thread(t2);
        t3.start();
        t1.start();
        while(true){
            System.out.println("Thread Principal");
        }
    }
}
