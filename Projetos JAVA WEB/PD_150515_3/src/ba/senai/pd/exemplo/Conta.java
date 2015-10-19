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
public class Conta {
    double saldo = 0 ;
    
  public void depositar(double valor){
      saldo+=valor;
  }
  
  public synchronized void sacar(double valor){
      //recomendável para bons usos e práticas synchronized(this){}
      try{
          Thread.sleep(100L);
          }catch(InterruptedException e){}
      saldo-=valor;
  }
}
