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
public class TestaSegundaThread {
    public static void main(String[] args) {
        SegundaThread st = new SegundaThread();
        Thread minhaThread = new Thread(st);
        while(minhaThread.isAlive()){
            System.out.println("Fazendo qualquer coisa");
        }
    }
}
