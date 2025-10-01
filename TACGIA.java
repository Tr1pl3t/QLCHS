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

public class TACGIA {
    private String maTG;
    private String ten;
    private int[] ngaySinh;
    private String quocTich;
    private String tieuSu;
    
    public TACGIA(){
        
    }
    
    public TACGIA(String maTG,String ten, int[] ngaySinh,
            String quocTich, String tieuSu){
        this.maTG = maTG;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.quocTich = quocTich;
        this.tieuSu = tieuSu;
        
    }
    
    public TACGIA(TACGIA tg){
        this.maTG = tg.maTG;
        this.ten = tg.ten;
        this.ngaySinh = tg.ngaySinh;
        this.quocTich = tg.quocTich;
        this.tieuSu = tg.tieuSu;
    }
    
    public String getMaTG(){
        return maTG;
    }
    
    public void setMaTG(String maTG){
        this.maTG = maTG;
    }
    
    public String getHoTen(){
        return ten;
    }
    
    public void setHoTen(String hoTen){
        this.ten = hoTen;
    }
    
    //getNgaySinh
    
    //setNgaySinh
    
    public String getQuocTich(){
        return quocTich;
    }
    
    public void setQuocTich(String quocTich){
        this.quocTich = quocTich;
    }
    
    public String getTieuSu(){
        return tieuSu;
    }
    
    public void setTieuSu(String tieuSu){
        this.tieuSu = tieuSu;
    }
    
    public String hamMaTG()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String temp = "";
        boolean check = true;
        System.out.print("Ma nha tac gia(5 ky tu): ");
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
    
    public void nhap()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nhap thong tin tac gia");
        System.out.print("Ten tac gia: ");
        ten = in.readLine();
        ten = ten.trim().replaceAll("\\s+", " ");//Xoa khoang cach du thua
        
        System.out.print("Ma tac gia: ");
        maTG = in.readLine();
        
        System.out.print("Ngay sinh: ");
        //ngay sinh
        
        System.out.print("Quoc tich: ");
        quocTich = in.readLine();
        
        System.out.print("Tieu su: ");
        tieuSu = in.readLine();
    }
    
    public void xuat(){
        System.out.println("Thong tin tac gia!");
        System.out.println(ten);
        System.out.println("Ma NV: "+maTG);
        //System.out.println("Ngay sinh: ");
        System.out.println("Quoc tich: "+quocTich);
        System.out.println("Tieu su: :"+tieuSu);
    }
    
    public void suaThongTin() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("""
                           Ban muon thay doi thong tin gi!
                           1. Ten tac gia
                           2. Ma tac gia
                           3. Ngay sinh
                           4. Quoc tich
                           5. Tieu su
                           0. Khong thay doi gi nua""");
            int choice;
            System.out.print("Lua chon: ");
            choice = Integer.parseInt(in.readLine());
            switch(choice){
                case 1:{
                    System.out.print("Ten tac gia: ");
                    ten = in.readLine();
                    ten = ten.trim().replaceAll("\\s+", " ");
                    break;
                }
                case 2:{
                    maTG = hamMaTG();//Nhap ma nv
                    break;
                }
                case 3:{
                    //Ngay sinh//Nhap chuc Vu
                    break;
                }
                case 4:{
                    System.out.print("Quoc tich: ");
                    quocTich = in.readLine();
                    break;
                }
                case 5:{
                    System.out.print("Tieu su: ");
                    tieuSu = in.readLine();
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
