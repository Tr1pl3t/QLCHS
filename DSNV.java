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
}
