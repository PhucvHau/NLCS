/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Time;

/**
 *
 * @author Mark Hi
 */
public class LichTrinh {
    private String Ma_LT,Ga_di,Ga_den, Ma_tau;
    private Time Tg_di, Tg_den;
    private int Soghe;
    private int tongtime;

    public int getTongtime() {
        return tongtime;
    }

    public void setTongtime(int tongtime) {
        this.tongtime = tongtime;
    }
    
    public String getMa_LT() {
        return Ma_LT;
    }

    public void setMa_LT(String Ma_LT) {
        this.Ma_LT = Ma_LT;
    }

    public String getGa_di() {
        return Ga_di;
    }

    public void setGa_di(String Ga_di) {
        this.Ga_di = Ga_di;
    }

    public String getGa_den() {
        return Ga_den;
    }

    public void setGa_den(String Ga_den) {
        this.Ga_den = Ga_den;
    }

    public String getMa_tau() {
        return Ma_tau;
    }

    public void setMa_tau(String Ma_tau) {
        this.Ma_tau = Ma_tau;
    }

    public Time getTg_di() {
        return Tg_di;
    }

    public void setTg_di(Time Tg_di) {
        this.Tg_di = Tg_di;
    }

    public Time getTg_den() {
        return Tg_den;
    }

    public void setTg_den(Time Tg_den) {
        this.Tg_den = Tg_den;
    }

    public int getSoghe() {
        return Soghe;
    }

    public void setSoghe(int Soghe) {
        this.Soghe = Soghe;
    }
    
}
