/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ba.senai.beans;

import com.ba.senai.Time;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Matthew
 */
@ManagedBean(name = "tmBean")
@SessionScoped
public class TimeBean {
    private Time time;
    private List<Time> times;

    public TimeBean() {
        time = new Time();
        times = new ArrayList <Time>();
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }
    
    public void salvar(){
        if(times.indexOf(time)==-1){
            times.add(time);
            time = new Time();
        }else{
            times.set(times.indexOf(time),time);
        }
    }
    public void editar(Time t) {
        time = t;
    }

    public void excluir(Time t) {
        times.remove(t);
    }
    
    

    
}
