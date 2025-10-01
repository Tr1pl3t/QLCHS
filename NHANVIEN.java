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
        
public class NHANVIEN {
    private String maNV;
    private String hoTen;
    private String ho; private String ten;
    private String chucVu;
    private float luong;
    private String SDT;
    
    //Default
    public NHANVIEN(){
        
    }
    //Parameterized
    public NHANVIEN(String hoTen, String ho, String ten, String chucVu,
            float luong, String SDT){
        this.hoTen = hoTen; 
        this.ho = ho;
        this.ten = ten;
        this.chucVu = chucVu;
        this.luong = luong;
        this.SDT = SDT;
    }
    //Copy
    public NHANVIEN(NHANVIEN nv){
        this.hoTen = nv.hoTen;
        this.ho = nv.ho;
        this.ten = nv.ten;
        this.chucVu = nv.chucVu;
        this.luong = nv.luong;
        this.SDT = nv.SDT;
    }
    
    public String getMaNV(){
        return maNV;
    }
    
    public void setMaNV(String maNV){
        this.maNV = maNV;
    }
    
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
    public String hamMaNV()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String temp = "";
        boolean check = true;
        System.out.print("Ma nhan vien (5 ky tu): ");
        while(check){
            temp = in.readLine();
            check = false;
            if(temp.length() != 5){
                check = true;
                System.out.println("Cu phap khong dung! Hay nhap lai: ");
            }
        }
        
        return temp;
    }
    
    public String hamChucVu()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        while(true){
            System.out.println("""
                    + Chon chuc vu!
                    + 1. Quan ly
                    + 2. Nhan vien""");
            System.out.print("Chon chuc vu: ");
            choice = Integer.parseInt(in.readLine());
            switch(choice){
                case 1: return "Quan ly";
                case 2: return "Nhan vien";
                default: System.out.println("Chon khong dung!");
            }
        }
    }
    
    public String hamSDT()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String temp = "";
        boolean check = true;
        System.out.print("So dien thoai (10 so): ");
        while(check){
            temp = in.readLine();
            check = false;
            if(temp.length() != 10 || temp.matches(".*[a-zA-Z].*")){ //Kiem tra du 10 so, va khong co chu
                check = true;
                System.out.println("Cu phap khong dung! Hay nhap lai: ");
            }
        }
        
        return temp;
    }
    
    public void nhap() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nhap thong tin nhan vien");
        System.out.print("Ho ten nhan vien: ");
        hoTen = in.readLine();
        hoTen = hoTen.trim().replaceAll("\\s+", " ");//Xoa khoang cach du thua
        String[] temp = hoTen.split("\\s+");
        ho = temp[0]; ten = temp[temp.length-1];
        
        maNV = hamMaNV();//Nhap ma nv
        
        chucVu = hamChucVu();//Nhap chuc Vu
        
        SDT = hamSDT();//Nhap so dien thoai
        System.out.print("Luong: ");
        luong = Integer.parseInt(in.readLine());
    }
    
    public void xuatNV(){
        System.out.println("Thong tin nhan vien!");
        System.out.println(hoTen);
        System.out.println("Ma NV: "+maNV);
        System.out.println("Chuc vu: "+chucVu);
        System.out.println("SDT: "+SDT);
        System.out.println("Luong: :"+luong);
    }
    
    public void suaThongTin()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("""
                           Ban muon thay doi thong tin gi!
                           1. Ho ten nhan vien
                           2. Ma nhan vien
                           3. Chuc vu
                           4. Luong
                           5. So dien thoai
                           0. Khong thay doi gi nua""");
            int choice;
            System.out.print("Lua chon: ");
            choice = Integer.parseInt(in.readLine());
            switch(choice){
                case 1:{
                    System.out.print("Ho ten nhan vien: ");
                    hoTen = in.readLine();
                    hoTen = hoTen.trim().replaceAll("\\s+", " ");//Xoa khoang cach du thua
                    String[] temp = hoTen.split("\\s+");
                    ho = temp[0]; ten = temp[temp.length-1];
                    break;
                }
                case 2:{
                    maNV = hamMaNV();//Nhap ma nv
                    break;
                }
                case 3:{
                    chucVu = hamChucVu();//Nhap chuc Vu
                    break;
                }
                case 4:{
                    System.out.print("Luong: ");
                    luong = Integer.parseInt(in.readLine());
                    break;
                }
                case 5:{
                    SDT = hamSDT();//Nhap so dien thoai
                    break;
                }
                case 0:return;
                default:{
                    System.out.print("Cu phap khong dung, hay nhap lai!");
                    break;
                }
            }
        }
        
    }
}
