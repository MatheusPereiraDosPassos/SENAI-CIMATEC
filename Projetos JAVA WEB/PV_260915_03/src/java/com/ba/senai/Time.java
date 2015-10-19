/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ba.senai;

/**
 *
 * @author Matthew
 */
public class Time {

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getDivisao() {
        return Divisao;
    }

    public void setDivisao(String Divisao) {
        this.Divisao = Divisao;
    }

    public Float getInvestimento() {
        return Investimento;
    }

    public void setInvestimento(Float Investimento) {
        this.Investimento = Investimento;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }
    private String Nome;
    private String Estado;
    private String Divisao;
    private  Float Investimento;
    private int Numero;
    
}
