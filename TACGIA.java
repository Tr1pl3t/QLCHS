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
import java.time.*;
import java.time.format.*;

public class TacGia {
    private String maTG;
    private String ten;
    private LocalDate ngaySinh;
    private String quocTich;
    
    public TacGia(){
        
    }
    
    public TacGia(String maTG,String ten, LocalDate ngaySinh,
            String quocTich, String tieuSu){
        this.maTG = maTG;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.quocTich = quocTich;
        
    }
    
    public TacGia(TacGia tg){
        this.maTG = tg.maTG;
        this.ten = tg.ten;
        this.ngaySinh = tg.ngaySinh;
        this.quocTich = tg.quocTich;
    }
    
    public String getMaTG(){
        return maTG;
    }
    
    public void setMaTG(String maTG){
        this.maTG = maTG;
    }
    
    public String getTen(){
        return ten;
    }
    
    public void setTen(String ten){
        this.ten = ten;
    }
    
    public LocalDate getNgaySinh(){
        return ngaySinh;
    }
    
    public void setNgaySinh(LocalDate ngaySinh){
        this.ngaySinh = ngaySinh;
    }
    
    public String getQuocTich(){
        return quocTich;
    }
    
    public void setQuocTich(String quocTich){
        this.quocTich = quocTich;
    }
    
    
    public LocalDate hamNgaySinh()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //tao format cua ngay/thang/nam
        LocalDate ngaySinhTemp = null;
        while(true){
            System.out.print("Nhap nhay sinh (dd/MM/yyy): ");
            String temp = in.readLine();
            
            try{
                ngaySinhTemp = LocalDate.parse(temp, fmt); //chuyển chuỗi từ temp thành format ngày
                
                if(ngaySinhTemp.isAfter(LocalDate.now())){ //kiểm tra ngày sinh có quá ngày hiện tại
                    System.out.println("Ngay sinh khong hop le! Hay nhap lai!");
                }
                else{
                    break;
                }
            }
            catch(DateTimeParseException e){ //kiểm tra hợp lệ của ngày tháng
                System.out.println("Ngay sinh khong hop le! Hay nhap lai!");
            }
        }
        
        
        return ngaySinhTemp;
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
        ngaySinh = hamNgaySinh();
        
        System.out.print("Quoc tich: ");
        quocTich = in.readLine();
        
        
    }
    
    public void xuat(){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("%-10s %-25s %-15s %-20s\n",
                    maTG, ten, ngaySinh.format(fmt), quocTich);
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
                    ngaySinh = hamNgaySinh();
                    break;
                }
                case 4:{
                    System.out.print("Quoc tich: ");
                    quocTich = in.readLine();
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
