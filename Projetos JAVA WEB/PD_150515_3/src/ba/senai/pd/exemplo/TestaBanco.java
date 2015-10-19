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
public class TestaBanco {
    public static void main(String[] args) {
        Conta cc = new Conta();
        cc.depositar(100);
        Banco b = new Banco(cc);
        Thread andreCC = new Thread(b,"André");
        Thread elineiCC = new Thread(b,"Elinei");
        andreCC.start();
        elineiCC.start();
    }
}
