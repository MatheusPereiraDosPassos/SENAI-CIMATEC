/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SiG;

/**
 *
 * @author Matthew
 */
public class Singleton {
    
    private String texto;
    private static Singleton instancia = null;

    public static Singleton getInstancia() {
        if(instancia == null){
            instancia = new Singleton();
        }
        return instancia;
    }
    
    private Singleton() {
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
    

    
    
    
    
}
