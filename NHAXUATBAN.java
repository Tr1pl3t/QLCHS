/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlchs;

/**
 *
 * @author ASUS
 */
import java.io.*;

public class NHAXUATBAN {
    private String maNXB;
    private String tenNXB;
    private String diaChi;
    
    public NHAXUATBAN(){
        
    }
    
    public NHAXUATBAN(String maNXB, String tenNXB, String diaChi){
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.diaChi = diaChi;
    }
    
    public NHAXUATBAN(NHAXUATBAN nxb){
        this.maNXB = nxb.maNXB;
        this.tenNXB = nxb.tenNXB;
        this.diaChi = nxb.tenNXB;
    }
    
    public String getMaNXB(){
        return maNXB;
    }
    
    public void setMaNXB(String maNXB){
        this.maNXB = maNXB;
    }
    
    public String getTenNXB(){
        return tenNXB;
    }
    
    public void setTenNXB(String tenNXB){
        this.tenNXB = tenNXB;
    }
    
    public String getDiaChi(){
        return diaChi;
    }
    
    public void setDiaChi(String diaChi){
        this.diaChi = diaChi;
    }
    
    public void nhap()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nhap thong tin nha xuat ban");
        System.out.print("Ten nha xuat ban: ");
        tenNXB = in.readLine();
        tenNXB = tenNXB.trim().replaceAll("\\s+", " ");//Xoa khoang cach du thua
        
        System.out.print("Ma nha xuat ban: ");
        maNXB = in.readLine();
        
        System.out.print("Dia chi: ");
        diaChi = in.readLine();
    }
    
    public void xuat(){
        System.out.println("Thong tin nha xuat ban");
        System.out.println("Ten: "+tenNXB);
        System.out.println("Ma so: "+maNXB);
        System.out.println("Dia chi: "+diaChi);
    }
    
    public void suaThongTin()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("""
                           Ban muon thay doi thong tin gi!
                           1. Ten nha xuat ban
                           2. Ma nha xuat ban
                           3. Dia chi
                           0. Khong thay doi gi nua""");
            int choice;
            System.out.print("Lua chon: ");
            choice = Integer.parseInt(in.readLine());
            
            switch(choice){
                case 1:{
                    System.out.print("Ten nha xuat ban: ");
                    tenNXB = in.readLine();
                    tenNXB = tenNXB.trim().replaceAll("\\s+", " ");//Xoa khoang cach du thua                  
                    break;
                }
                case 2:{
                    System.out.print("Ma nha xuat ban: ");
                    maNXB = in.readLine();
                    break;
                }
                case 3:{
                    System.out.print("Dia chi: ");
                    diaChi = in.readLine();
                    break;
                }
                case 0: return;
                default: System.out.println("Cu phap khong hop le, hay nhap lai"); break;
            }
        }
    }
    
}
