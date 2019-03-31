/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Mark Hi
 */
public class Info_kh {
    private String MsHK,TenHk,Cmnd,Email,Sodt;
    private Date Ngaysinh; 
    private String Tennd,CmndND;

    public String getTennd() {
        return Tennd;
    }

    public void setTennd(String Tennd) {
        this.Tennd = Tennd;
    }

    public String getCmndND() {
        return CmndND;
    }

    public void setCmndND(String CmndND) {
        this.CmndND = CmndND;
    }
    

    public String getMsHK() {
        return MsHK;
    }

    public void setMsHK(String MsHK) {
        this.MsHK = MsHK;
    }

    public String getTenHk() {
        return TenHk;
    }

    public void setTenHk(String TenHk) {
        this.TenHk = TenHk;
    }

    public String getCmnd() {
        return Cmnd;
    }

    public void setCmnd(String Cmnd) {
        this.Cmnd = Cmnd;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSodt() {
        return Sodt;
    }

    public void setSodt(String Sodt) {
        this.Sodt = Sodt;
    }

    public Date getNgaysinh() {
        return Ngaysinh;
    }
    public String getString_day(){
        DateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        return fm.format(Ngaysinh);
    }
    public void setNgaysinh(Date Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }
    
}
