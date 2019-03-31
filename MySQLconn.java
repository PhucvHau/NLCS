/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cotroller;

import Model.Ghe;
import Model.Info_Ve;
import Model.Info_kh;
import Model.Khuyenmai;
import Model.LichTrinh;
import Model.Tau;
import Model.Vetau;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mark Hi
 */
public class MySQLconn {
    
    private Connection conn;
    /**
     *
     */
    public  MySQLconn()  {
        final String url = "jdbc:mysql://127.0.0.1:3306/nlcs";
        final String user = "root";
        final String password = "phuchau123";
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn= (Connection) DriverManager.getConnection(url,user,password);
                System.out.println("ket noi thanh cong");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLconn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ArrayList<LichTrinh> Tim_lt(String Gadi,String Gaden){
        ArrayList<LichTrinh> List= new ArrayList();
        String sql;
        sql="call seach_tuyen(?,?)";
        try {
            PreparedStatement ps=conn.prepareCall(sql);
            ps.setString(1,Gadi);
            ps.setString(2,Gaden);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                 LichTrinh lt= new LichTrinh();
                lt.setMa_LT(rs.getString(1));
                lt.setGa_di(rs.getString(2));
                lt.setGa_den(rs.getString(3));
                lt.setMa_tau(rs.getString(4));
                lt.setTg_di(rs.getTime(5));
                lt.setTg_den(rs.getTime(6));
                lt.setTongtime(rs.getInt(7));
                lt.setSoghe(rs.getInt(8));
                List.add(lt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLconn.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("k tim dc ma lich trinh");
        }
                
        return List;
    }
    public ArrayList<Vetau>     Xem_giave(String malt){
        ArrayList<Vetau> List=new ArrayList();
        String sql;
        sql="call xem_gia_ve(?)";
        try {
            PreparedStatement ps=conn.prepareCall(sql);
            ps.setString(1, malt);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Vetau vt= new Vetau();
                vt.setMa_ghe(rs.getString(1));
                vt.setGiave(rs.getInt(3));
                List.add(vt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLconn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return List;
    }
    public ArrayList<Ghe>     Xem_giave1(String malt){
        ArrayList<Ghe> List=new ArrayList();
        String sql;
        sql="call xem_gia_ve(?)";
        try {
            PreparedStatement ps=conn.prepareCall(sql);
            ps.setString(1, malt);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Ghe g= new Ghe();
                g.setTen_loaighe(rs.getString(2));
                List.add(g);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLconn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return List;
    }
    public ArrayList<String> Ga(){
        ArrayList<String> List=new ArrayList();
        String sql;
        sql="select distinct Ga_Di from lichtrinh";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String s;
                s = rs.getString("Ga_Di");
                List.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLconn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return List;
    }
    public ArrayList<String> Ga_den(String ga_di){
        ArrayList<String> List=new ArrayList();
        String sql;
        sql="select distinct Ga_Den from lichtrinh where Ga_Di=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, ga_di);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String s;
                s = rs.getString("Ga_Den");
                List.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLconn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return List;
    }
    
    public ArrayList<Ghe> LoaiGhe() {
        ArrayList<Ghe> List=new ArrayList();
        String sql;
        sql="select * from ghe";
        try {
            PreparedStatement ps=conn.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Ghe g= new Ghe();
                g.setMa_ghe(rs.getString(1));
                g.setTen_loaighe(rs.getString(2));
                List.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLconn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return List;
    }
    public String Loai_Ghe(String mghe) {
        String g = null;
        String sql;
        sql="select TenloaiGhe from ghe where MaGhe=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, mghe);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                g=rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLconn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;
    }
    public ArrayList<Vetau> Info_tau_ghe(String matau, String mlt){
        ArrayList<Vetau> List = new ArrayList();
        String sql;
        sql="call infoTau_ghe(?,?)";
        try {
            PreparedStatement ps=conn.prepareCall(sql);
            ps.setString(1, matau);
            ps.setString(2, mlt);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Vetau vt=new Vetau();
                Ghe g=new Ghe();
                vt.setMa_ghe(rs.getString(1));
                List.add(vt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLconn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return List;
    }
    public ArrayList<Ghe> Info_tau_ghe1(String matau){
        ArrayList<Ghe> List=new ArrayList();
        String sql;
        sql="call infotau_ghe(?)";
        try {
            PreparedStatement ps=conn.prepareCall(sql);
            ps.setString(1, matau);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Ghe g=new Ghe();
                g.setTen_loaighe(rs.getString(2));
                List.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLconn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return List;
    }
    public int giave(String malt,String maghe){
        int s = 0;
        String sql;
        sql="select gia_ve(?,?)";
            try {
            PreparedStatement ps=conn.prepareCall(sql);
            ps.setString(1, malt);
            ps.setString(2, maghe);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                s=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLconn.class.getName()).log(Level.SEVERE, null, ex);
        }
           return s;
        
    }
    public String mave(String malt, String maghe){
        String idve=null;
        String sql;
        sql="select Msve from Vetau where Ma_LichTrinh=? and Maghe=? ";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, malt);
            ps.setString(2, maghe);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                idve=rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLconn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idve;
    }
    public Tau info_tau(String matau){
        Tau t=new Tau();
        String sql;
        sql="call infoTau(?)";
            try {
            PreparedStatement ps=conn.prepareCall(sql);
            ps.setString(1, matau);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                t.setMa_tau(rs.getString(1));
                t.setTen_tau(rs.getString(2));
                t.setLoai_tau(rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLconn.class.getName()).log(Level.SEVERE, null, ex);
        }
           return t;
    }
    public boolean add_info_kh(Info_kh u,String date){
        String sql;
        sql="call add_info_kh1(?,?,?,?,?,?,?,?)";
        DateFormat fm = new SimpleDateFormat("yyyy-MM-dd"); 
        try {
            PreparedStatement ps=conn.prepareCall(sql);
            ps.setString(1, u.getMsHK());
            ps.setString(2, u.getTenHk());
            ps.setString(3, date);
            ps.setString(4, u.getCmnd());
            ps.setString(5, u.getEmail());
            ps.setString(6, u.getSodt());
            ps.setString(7, u.getTennd());
            ps.setString(8, u.getCmndND());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLconn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public int cr_mahanhkhach(){
        String sql="select count(mshanhkhach) from info_kh";
        int maso=0;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
               maso=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLconn.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        return maso;
    }
    public boolean add_info_Ve(Info_Ve v,String date){
        String sql;
        sql="call dat_ve(?,?,?,?,?,?)";
        try {
            PreparedStatement ps= conn.prepareCall(sql);
            ps.setString(1, v.getMsve());
            ps.setString(2, v.getMa_lt());
            ps.setString(3,v.getMsHk());
            ps.setString(4,v.getMadt());
            ps.setInt(5,v.getThanhtien());
            ps.setString(6, date);
            return ps.executeUpdate() >0;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLconn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean Update_info_kh(Info_kh u,String mve, String madt){
        String sql;
        sql="call Sua_thong_tin_ve(?,?,?,?,?,?,?,?)";
        DateFormat fm = new SimpleDateFormat("yyyy-MM-dd"); 
        try {
            PreparedStatement ps=conn.prepareCall(sql);
            ps.setString(1,mve);
            ps.setString(2, u.getMsHK());
            ps.setString(3, madt);
            ps.setString(4, u.getTenHk());
            ps.setDate(5, u.getNgaysinh());
            ps.setString(6, u.getCmnd());
            ps.setString(7, u.getEmail());
            ps.setString(8, u.getSodt());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLconn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public LichTrinh get_lt(String malt){
    LichTrinh lt=new LichTrinh();
    String sql;
    sql="select * from lichtrinh where Ma_LichTrinh=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,malt);
            ResultSet rs=ps.executeQuery();
         
            while(rs.next()){
                
                lt.setMa_LT(rs.getString(1));
                lt.setGa_di(rs.getString(2));
                lt.setGa_den(rs.getString(3));
                lt.setMa_tau(rs.getString(4));
                lt.setTg_di(rs.getTime(5));
                lt.setTg_den(rs.getTime(6));
                lt.setTongtime(rs.getInt(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLconn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lt;
    }
    public ArrayList<Khuyenmai> km(){
        ArrayList<Khuyenmai> list=new ArrayList<>();
        String sql;
        sql="select * from khuyenmai";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Khuyenmai km=new Khuyenmai();
                km.setMaDt(rs.getString(1));
                km.setTenDt(rs.getString(2));
                km.setGiam(rs.getFloat(3));
                list.add(km);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLconn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        MySQLconn t=new MySQLconn();
        ArrayList<LichTrinh> list = new ArrayList<>();
        list=t.Tim_lt("Sài Gòn","Hà Nội");
        for(LichTrinh conn : list){
            System.out.println("ma Lich Trinh:"+ conn.getMa_LT());
            System.out.println("Ga di :"+conn.getGa_di());
            System.out.println("Ga den :"+conn.getGa_den());
            System.out.println("Ma tau :"+ conn.getMa_tau());
            System.out.println("tine di :"+ conn.getTg_di());
            System.out.print("thoi gian den"+conn.getTg_den());
            System.out.print("   " + conn.getTongtime() +"    " +conn.getSoghe());
        } 
        /*ArrayList<Vetau> list=new  ArrayList();
        ArrayList<Ghe> list1=new  ArrayList();
        ArrayList lt=new ArrayList();
        list=t.Info_tau_ghe("SE4");
        //list=t.Info_tau_ghe("SE4");
        Iterator<Vetau> itr=list.iterator();
        while(itr.hasNext()){
           System.out.println("Ma ghe :"+ itr.next());
           
       }*/
    }
    
}
