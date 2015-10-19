/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba.senai.pd.exemplo;

/**
 *
 * @author Matthew
 */
public class Banco implements Runnable{
    private Conta c;
    private double saque = 25;
    
    public Banco(Conta c){
        this.c = c;
    }

    @Override
    public void run() {
        c.sacar(saque);
        String tNome = Thread.currentThread().getName();
        System.out.println("Saque de " + saque + "efetuado( por: " +tNome+")\nSaldo =" + c.saldo);        
    }
    
}
