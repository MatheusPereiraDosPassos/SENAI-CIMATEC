/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ba.senai.fja.singleton;

import SiG.Singleton;

/**
 *
 * @author Matthew
 */
public class AulaSingleton {
    
    public static void main(String[] args) {
        
      Singleton var1 = Singleton.getInstancia();
      var1.setTexto("Maria Jose");
      
      Singleton var2 = Singleton.getInstancia();
      var2.setTexto("Matthew");
      
        System.out.println("Objeto var1 " + var1.getTexto());
        System.out.println("Objeto var2 " + var2.getTexto());
    }
    
}
