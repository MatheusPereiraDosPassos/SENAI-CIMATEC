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
public class SegundaThread implements Runnable {
    private int contagem = 100;
    
    @Override
    public void run() {
        while(contagem>0){
            System.out.println(contagem);
            contagem--;
        }
    }
    
}
