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
import java.util.Arrays;

public class DSNV {
    private NHANVIEN[] ds;
    //default
    public DSNV(){
        ds = new NHANVIEN[0];
    }
    //parameterized
    public DSNV(NHANVIEN[] temp){
        ds = temp;
    }
    //copy
    public DSNV(DSNV temp){
        ds = temp.ds;
    }
    
    public NHANVIEN[] getDS(){
        return ds;
    }
    //co the khong can set?
    public void setDS(NHANVIEN[] temp){
        ds = temp;
    }
    
    //nhap, xuat, them/xoa, tim kiem, sap xep theo ten/luong/...
    
    public void chonChucNang() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int choice;
        while(true){
            System.out.println("""
                               Chon chuc nang can thuc hien!
                               1. Khoi tao danh sach
                               2. Them nhan vien
                               3. Xoa nhan vien
                               4. Sua thong tin nhan vien
                               5. Xuat danh sach nhan vien
                               6. Tim kiem nhan vien
                               7. Sap xep theo ten
                               8. Sap xep theo luong
                               0. Thoat chuong trinh""");
            choice = Integer.parseInt(in.readLine());
            switch(choice){
                case 1: khoiTaoDS(); break;
                case 2: themNV(); break;
                case 3: xoaNV(); break;
                case 4: suaThongTin(); break;
                case 5: xuatDS(); break;
                case 6: timKiemNV(); break;
                case 7: sortByTen(); break;
                case 8: sortByLuong(); break;
                case 0: return;
                default: System.out.println("Cu phap khong dung, hay nhap lai!"); break;
            }
        }
    }
    
    public void khoiTaoDS()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Nhap so luong nhan vien: ");
        int soLuong = Integer.parseInt(in.readLine());
        
        ds = new NHANVIEN[soLuong]; //cap phat cho mang
        
        for(int i = 0; i < soLuong; i++){
            System.out.print("Nguoi thu "+(i+1)+" - ");
            ds[i] = new NHANVIEN(); //khoi tao doi tuong
            ds[i].nhap();
            System.out.println("____________________________");
        }
    }
    
    public void xuatDS(){
        System.out.println("DANH SACH NHAN VIEN!");
        // In tieu de
        System.out.printf("%-10s %-20s %-15s %-10s %-15s\n",
                "Ma NV", "Ho Ten", "Chuc Vu", "Luong", "SDT");
        System.out.println("--------------------------------------------------------------------------");

        // In danh sach
        for (NHANVIEN nv : ds) {
            System.out.printf("%-10s %-20s %-15s %-10.2f %-15s\n",
                    nv.getMaNV(), nv.getHoTen(), nv.getChucVu(), 
                    nv.getLuong(), nv.getSDT());
        }
        
    }
    
    public void themNV()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Them bao nhieu nhan vien: ");
        int soLuong = Integer.parseInt(in.readLine());
        ds = Arrays.copyOf(ds, ds.length+soLuong);
        for(int i = ds.length-soLuong; i < ds.length; i++){
            System.out.print("Nguoi thu "+(i+1)+" - ");
            ds[i] = new NHANVIEN(); //khoi tao doi tuong
            ds[i].nhap();
            System.out.println("____________________________");
        }
        
    }
    
    public void xoaNV()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        if (ds == null || ds.length == 0) {
            System.out.println("Danh sach rong, khong co gi de xoa!");
            return;
        }

        
        System.out.print("Nhap ma so NV can xoa: ");
        String temp = in.readLine();
        int check = -1;
        for(int i = 0; i < ds.length; i++){
            if(temp.equals(ds[i].getMaNV())){
                check = i;
                break;
            }
        }
        
        if(check != -1){
            for(int i = check; i < ds.length-1; i++){
                ds[i] = ds[i+1];
            }
            ds = Arrays.copyOf(ds, ds.length-1);
        }
        else{
            System.out.println("Ma so khong tim thay!");
        }
        
    }
    
    public void suaThongTin()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Nhap ma so nhan vien can sua: ");
        String temp = in.readLine();
        int check = -1;
        for(int i = 0; i < ds.length; i++){
            if(temp.equals(ds[i].getMaNV())){
                check = i;
                break;
            }
        }
        
        if(check != -1){
            ds[check].suaThongTin();
        }
        else{
            System.out.println("Ma so khong tim thay!");
        }
    }
    
    public void timKiemNV()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Nhap ma so nhan vien can tim: ");
        String temp = in.readLine();
        
        for(int i = 0; i < ds.length; i++){
            if(temp.equals(ds[i].getMaNV())){
                ds[i].xuatNV();
                return;
            }
        }
        
        System.out.println("Khong tim thay nhan vien can tim!"); 
    }
    
    public void sortByTen() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        while(true){
            System.out.println("""
                           Ban muon sap xep theo kieu nao?
                           1. Sap xep A-z
                           2. Sap xep a-A
                           0. Khong sap xep""");
            choice = Integer.parseInt(in.readLine());
            if(choice == 1){
                for(int i = 0; i < ds.length-1; i++){
                    for(int y = 0; y < ds.length-i-1; y++){
                        if(ds[y].getTen().compareToIgnoreCase(ds[y+1].getTen()) > 0){ //>0 -> str1 > str2
                            NHANVIEN temp = ds[y];
                            ds[y] = ds[y+1];
                            ds[y+1] = temp;
                        }
                        
                    }
                }
                return;
            }
            else if(choice == 2){
                for(int i = 0; i < ds.length-1; i++){
                    for(int y = 0; y < ds.length-i-1; y++){
                        if(ds[y].getTen().compareToIgnoreCase(ds[y+1].getTen()) < 0){ //<0 -> str1 < str2
                            NHANVIEN temp = ds[y];
                            ds[y] = ds[y+1];
                            ds[y+1] = temp;
                        }
                        
                    }
                }
                return;
            }
            else if(choice == 0){
                return;
            }
            else{
                System.out.println("Cu phap khong dung, hay nhap lai!");
            }
        }
        
    }
    
    public void sortByLuong() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        while(true){
            System.out.println("""
                           Ban muon sap xep theo kieu nao?
                           1. Sap xep tu thap den cao
                           2. Sap xep tu cao den thap
                           0. Khong sap xep""");
            choice = Integer.parseInt(in.readLine());
            
            if(choice == 1){
                for(int i = 0; i < ds.length-1; i++){
                    for(int y = 0; y < ds.length-i-1; y++){
                        if(ds[y].getLuong() > ds[y+1].getLuong()){
                            NHANVIEN temp = ds[y];
                            ds[y] = ds[y+1];
                            ds[y+1] = temp;
                        }
                        
                    }
                }
                return;
            }
            else if(choice == 2){
                for(int i = 0; i < ds.length-1; i++){
                    for(int y = 0; y < ds.length-i-1; y++){
                        if(ds[y].getLuong() < ds[y+1].getLuong()){
                            NHANVIEN temp = ds[y];
                            ds[y] = ds[y+1];
                            ds[y+1] = temp;
                        }
                        
                    }
                }
                return;
            }
            else if(choice == 0){
                return;
            }
            else{
                System.out.println("Cu phap khong dung, hay nhap lai!");
            }
        }
    }
}
