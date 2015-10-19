/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.senai.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



/**
 *
 * @author Matthew
 */
@ManagedBean(name="calcBean")
@SessionScoped
public class CalculadoraBean {
    
    private double valor1;

    public double getValor1() {
        return valor1;
    }

    public void setValor1(double valor1) {
        this.valor1 = valor1;
    }

    public double getValor2() {
        return valor2;
    }

    public void setValor2(double valor2) {
        this.valor2 = valor2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }
    private double valor2;
    private double resultado;
    private String op;
    
    public void calcular(){
        switch(op.charAt(0)){
            case'+':
                resultado = valor1 + valor2;
                break;
            case'-':
                resultado = valor1 - valor2;
                break;
            case'*':
                resultado = valor1 * valor2;
                break;
            case'/':
                resultado = valor1 / valor2;
                break;
            
        }
    }
    
}
